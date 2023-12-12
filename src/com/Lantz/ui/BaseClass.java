package com.Lantz.ui;

import com.Lantz.FrameWork.BeanFactory;
import com.Lantz.bean.User;

import java.util.ResourceBundle;
import java.util.Scanner;

public abstract class BaseClass {

    protected static Scanner input = new Scanner(System.in);
    public static User currUser; // 当前用户对象
    protected BeanFactory beanFactory = null;
    private static ResourceBundle r = ResourceBundle.getBundle("com.Lantz.res.r");

    public static String getString(String key){
        return r.getString(key);
    }

    public static void println(String s){
        System.out.println(s);
    }

    public static void print(String s){
        System.out.print(s);
    }

    public BaseClass() {
        beanFactory = BeanFactory.init();
    }

}
