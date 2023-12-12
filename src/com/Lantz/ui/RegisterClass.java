package com.Lantz.ui;

import com.Lantz.bean.User;
import com.Lantz.service.UserService;
import com.Lantz.service.impl.UserServiceImpl;
import com.Lantz.utils.BusinessException;

public class RegisterClass extends BaseClass{
    /**
     * ����� LoginClass������һ��
     */
    private UserService userService;
    public RegisterClass(){
        userService = (UserService) beanFactory.getBean("userService");
    }

    public void register() throws BusinessException {

        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        User user = new User();
//        UserService userService = new UserServiceImpl();
        userService.register(user);
    }

}
