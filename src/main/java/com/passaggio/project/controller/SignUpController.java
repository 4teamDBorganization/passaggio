package com.passaggio.project.controller;

import com.passaggio.project.models.signup.SignUpService;
import com.passaggio.project.view.signup.SignUp;

public class SignUpController {
    private final SignUp signUp;
    private final SignUpService signUpService;

    public SignUpController(){
        signUp =new SignUp();
        signUpService = new SignUpService();

    }

    private void regispterSignU(){
//        SignUpService signUpService
    }

}
