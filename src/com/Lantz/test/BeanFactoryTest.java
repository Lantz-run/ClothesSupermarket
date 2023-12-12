package com.Lantz.test;

import com.Lantz.FrameWork.BeanFactory;
import org.junit.Test;

import java.util.List;

public class BeanFactoryTest {

    @Test
    public void test(){
        // 初始化BeanFactory
        BeanFactory beanFactory = BeanFactory.init();
        Object bean2 = beanFactory.getBean("userService");
        Object bean1 = beanFactory.getBean("clothesService");


        if (bean1 != null){
            System.out.println("clothesService 已成功获取！");
        }else {
            System.out.println("无法获取 clothesService.");
        }

        if (bean2 != null){
            System.out.println("userService 已成功获取！");
        }else {
            System.out.println("无法获取 userService.");
        }
    }

}
