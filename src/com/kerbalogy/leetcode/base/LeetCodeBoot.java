package com.kerbalogy.leetcode.base;

import com.kerbalogy.leetcode.Main;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/20 20:03
 * @description
 */
@Slf4j
public class LeetCodeBoot {
    public static void run() {
        List<Class<? extends AbstractLeetcodable>> classes = findClassesWithRunAnnotation();
        for (Class<? extends AbstractLeetcodable> clazz : classes) {
            Run runAnnotation = clazz.getAnnotation(Run.class);

            // 先打印信息，执行放最后
            boolean runCode = false;

            if (shouldExecute(clazz)) {
                try {
                    AbstractLeetcodable<?> instance = clazz.getDeclaredConstructor().newInstance();


                    if (runAnnotation.notice()) {
                        System.out.println("这一题被标记了提示，不执行");
                    }
                    if (runAnnotation.everPassed()) {
                        System.out.println("这道题目曾经做过");
                    }
                    if (runAnnotation.checkSolution()) {
                        System.out.println("看了答案才会做");
                    }

                    instance.title = runAnnotation.title();
                    instance.code = runAnnotation.code();

                    if (! runAnnotation.notice())
                        instance.run(); // 调用func方法


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static List<Class<? extends AbstractLeetcodable>> findClassesWithRunAnnotation() {
        List<Class<? extends AbstractLeetcodable>> classes = new ArrayList<>();
        String packageName = "com.kerbalogy.leetcode"; // 替换成实际的包名
        String packagePath = packageName.replace('.', '/');
        ClassLoader classLoader = Main.class.getClassLoader();
        try {
            URL packageURL = classLoader.getResource(packagePath);
            if (packageURL != null) {
                File packageDir = new File(packageURL.toURI()); // Use toURI() to avoid potential null
                if (packageDir.exists()) {
                    findClassesRecursively(packageName, packageDir, classes);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    private static void findClassesRecursively(String packageName, File directory, List<Class<? extends AbstractLeetcodable>> classes) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                findClassesRecursively(packageName + "." + file.getName(), file, classes);
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                try {
                    Class<?> clazz = Class.forName(className);
                    if (clazz.isAnnotationPresent(Run.class) && AbstractLeetcodable.class.isAssignableFrom(clazz)) {
                        classes.add(clazz.asSubclass(AbstractLeetcodable.class));
                    }
                } catch (ClassNotFoundException | ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean shouldExecute(Class<? extends AbstractLeetcodable> clazz) {
        if (clazz.isAnnotationPresent(Run.class)) {
            Run runAnnotation = clazz.getAnnotation(Run.class);
            if (runAnnotation.hold()) {
                return false;
            } else if (runAnnotation.passed()) {
                return false;
            } else {
                return true;
            }

        }
        return false; // 默认情况下，如果类没有标记@Run注解，则执行func方法
    }
}
