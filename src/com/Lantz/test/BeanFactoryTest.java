package com.Lantz.test;

import com.Lantz.FrameWork.BeanFactory;
import org.junit.Test;

import java.util.List;

public class BeanFactoryTest {

    @Test
    public void test(){
        // ��ʼ��BeanFactory
        BeanFactory beanFactory = BeanFactory.init();
        Object bean2 = beanFactory.getBean("userService");
        Object bean1 = beanFactory.getBean("clothesService");


        if (bean1 != null){
            System.out.println("clothesService �ѳɹ���ȡ��");
        }else {
            System.out.println("�޷���ȡ clothesService.");
        }

        if (bean2 != null){
            System.out.println("userService �ѳɹ���ȡ��");
        }else {
            System.out.println("�޷���ȡ userService.");
        }
    }

}
