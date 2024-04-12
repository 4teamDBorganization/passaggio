package com.passaggio.project.controller;

import com.passaggio.project.models.signup.SignUpDTO;
import com.passaggio.project.models.login.LoginService;
import com.passaggio.project.user.Delay;
import com.passaggio.project.view.login.Login;

import java.util.Map;

public class LoginController {

    public final Login login;
    public final LoginService loginService;

    public LoginController(){
        login = new Login();
        loginService = new LoginService();
    }

    public void goLogin(Map<String, String> parameter){

        String userId = parameter.get("userId");
        String userPwd = parameter.get("userPwd");

        loginService.gologin(userId, userPwd);

        System.out.println();
        System.out.println("================================");
        System.out.println("로그인 되었습니다.");
        System.out.println("================================");
        System.out.println();
        Delay.countdelay(2000);
    }

}