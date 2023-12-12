package com.Lantz.service;

import com.Lantz.bean.User;
import com.Lantz.utils.BusinessException;

public interface UserService {

    public User register(User user) throws BusinessException;

    public User login(String username, String password) throws BusinessException;

}
