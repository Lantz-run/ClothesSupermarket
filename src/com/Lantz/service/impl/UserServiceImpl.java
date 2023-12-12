package com.Lantz.service.impl;

import com.Lantz.bean.User;
import com.Lantz.service.UserService;
import com.Lantz.ui.BaseClass;
import com.Lantz.utils.BusinessException;
import com.Lantz.utils.EmptyUtils;
import com.Lantz.utils.UserIO;

public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO = new UserIO();
        userIO.add(user);
        userIO.writeUser();

        BaseClass.currUser = user;
        return user;
    }

    @Override
    public User login(String username, String password) throws BusinessException {

        if (EmptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        if (EmptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }

        UserIO userIO = new UserIO();
        User user = userIO.findByUsernameAndPassword(username, password);

        return user;
    }
}
