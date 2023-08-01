package com.kerbalogy.leetcode.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/31 21:55
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Hard {

    boolean checkSolution() default true;

}
