package com.Lantz.ui;

import com.Lantz.bean.User;
import com.Lantz.service.UserService;
import com.Lantz.service.impl.UserServiceImpl;
import com.Lantz.utils.BusinessException;

public class LoginClass extends BaseClass{
    /**
     * ʹ�����ֱ��뷽����������δ��Ҫ�������ļ���ֻ��Ҫ��getBean()�е�userService�����޸ļ���
     * ����LoginClass�಻��ȫ������UserServiceImpl������������ UserService����ӿ�
     */
    private UserService userService;
    public LoginClass(){
        userService = (UserService) beanFactory.getBean("userService");
    }

    public void login() throws BusinessException{
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();

//        UserService userService = new UserServiceImpl();
        User user = new User(username, password);

        if (user != null){
            currUser = user;
        }else {
            throw new BusinessException("login.error");
        }


    }

}
