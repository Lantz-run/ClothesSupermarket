package com.Lantz.ui;

import com.Lantz.bean.User;
import com.Lantz.service.UserService;
import com.Lantz.service.impl.UserServiceImpl;
import com.Lantz.utils.BusinessException;

public class LoginClass extends BaseClass{
    /**
     * 使用这种编码方法，方便在未来要改配置文件，只需要在getBean()中的userService里面修改即可
     * 这样LoginClass类不完全依赖于UserServiceImpl，而是依赖于 UserService这个接口
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
