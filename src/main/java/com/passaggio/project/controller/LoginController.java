package com.passaggio.project.controller;

import com.passaggio.project.model.login.LoginService;
import com.passaggio.project.delay.Delay;
import com.passaggio.project.view.login.Login;

import java.util.Map;

public class LoginController {

    public final Login login;
    public final LoginService loginService;

    public LoginController(){
        login = new Login();
        loginService = new LoginService();
    }

    //아이디 일치 확인
    public static boolean matchId(String id) {
        return LoginService.isIdInUse(id);
    }
    //비밀번호 일치 확인
    public static boolean matchPwd(String id, String pwd) {return LoginService.isPwInUse(id,pwd);
    }
    public void goLogin(Map<String, String> parameter){

        String userId = parameter.get("userId");
        String userPwd = parameter.get("userPwd");

        loginService.gologin(userId, userPwd);

        String userNickName = loginService.WhatIsNickName(userId);


        System.out.println();
        System.out.println("================================");
        System.out.println("로그인 되었습니다.");
        System.out.println("================================");
        System.out.println();
        Delay.countdelay(1000);
        System.out.println("현재 접속 Id는 : " + "'"+userId+"'" + " 이고 " + "당신의 닉네임은 : " + "'"+userNickName+"'" + "입니다.");
        System.out.println();
        Delay.countdelay(2000);
    }

}
