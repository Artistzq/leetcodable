package com.kerbalogy.leetcode.base;

import com.dxy.library.json.jackson.JacksonUtil;

/**
 * @author yaozongqing@outlook.com
 * @date 2023/7/18 20:34
 * @description
 */
public abstract class AbstractLeetcodable <T> implements Leetcodable<T>{

    protected int code;

    protected String title;

    protected void setCodeAndTitle(){

    }

    public void run() {
        setCodeAndTitle();

        String msg = String.format("%d. %s", code, title);
        System.out.println("RUNNING: " + msg);

        T result = this.prepareDataAndRun();

        System.out.println(JacksonUtil.to(result));

        System.out.println();
    }

}
