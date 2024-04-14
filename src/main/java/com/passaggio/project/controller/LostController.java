package com.passaggio.project.controller;

import com.passaggio.project.model.login.LoginService;
import com.passaggio.project.view.login.Login;
import com.passaggio.project.view.lostaccount.LostAccountService;

public class LostController {
    public final Login login;
    public final LoginService loginService;

    public LostController(){
        login = new Login();
        loginService = new LoginService();
    }

    public static boolean findid(int seq, String nick, String gender) {
        return LostAccountService.findmyid(seq, nick, gender);
    }

    public static boolean findpwd(int seq, String id) {
        return LostAccountService.findmypwd(seq, id);
    }


}

