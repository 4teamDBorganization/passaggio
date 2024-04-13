package com.passaggio.project.view.lostaccount;

import com.passaggio.project.models.login.LoginService;
import com.passaggio.project.view.login.Login;

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


}

