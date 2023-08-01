package com.kerbalogy.leetcode.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/18 20:28
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Run {

    boolean passed() default false;

    boolean hold() default false;

    boolean everPassed() default false;

    boolean checkSolution() default false;

    String comment() default "";

    int code() default 0;

    String title() default "";

}
