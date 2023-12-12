package com.Lantz.ui;

import com.Lantz.ui.BaseClass;
import com.Lantz.utils.BusinessException;
import com.Lantz.utils.UserIO;
import org.junit.Test;

public class WelcomeClass extends BaseClass {


    @Test
    public void start(){
        println(getString("info.welcome"));
        UserIO userIO = new UserIO();
        userIO.readUser();
        userIO.writeUser();
        boolean flag = true;
        while (flag){
            println(getString("info.login.reg"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1":
                    try {
                        new LoginClass().login();
                        flag = false;
                        println(getString("login.success"));
                    }catch(BusinessException e){
                        println(getString(e.getMessage()));
                    }
                    break;
                case "2":
                    flag = false;
                    try{
                        new RegisterClass().register();
                        println(getString("reg.success"));
                    } catch(BusinessException e){
                        println(getString("reg.error"));
                    }
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }
        HomeClass homeClass = new HomeClass();
        homeClass.show();
    }

}
