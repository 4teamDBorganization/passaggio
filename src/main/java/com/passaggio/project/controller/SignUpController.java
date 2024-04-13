package com.passaggio.project.controller;

import com.passaggio.project.models.signup.SignUpDTO;
import com.passaggio.project.models.signup.SignUpService;
import com.passaggio.project.user.Delay;
import com.passaggio.project.view.signup.SignUp;

import java.util.Map;

public class SignUpController {
    public final SignUp signUp;
    public final SignUpService signUpService;

    public SignUpController(){
        signUp =new SignUp();
        signUpService = new SignUpService();

    }

    //아이디 중복 확인
    public boolean checkIdDuplicate(String userId) {
        return signUpService.isIdAlreadyInUse(userId);
    }

    //닉네임 중복 확인
    public boolean checkNick(String nick) {
        return signUpService.isNickAlreadyInUse(nick);
    }

    public void registerSignUp(Map<String, String> parameter) {

        String userId = parameter.get("userId");
        String userPwd = parameter.get("userPwd");
        String userNickName = parameter.get("userNickName");
        char userGender = parameter.get("userGender").charAt(0);

        SignUpDTO signUpDTO = new SignUpDTO();

        signUpDTO.setId(userId);
        signUpDTO.setPwd(userPwd);
        signUpDTO.setNick(userNickName);
        signUpDTO.setGender(userGender);

        signUpService.registerUser(signUpDTO);

        System.out.println();
        System.out.println("================================");
        System.out.println("회원가입이 완료되었습니다.");
        System.out.println("3초 뒤에 처음 화면으로 돌아갑니다.");
        System.out.println("================================");
        System.out.println();
        Delay.countdelay(3000);
    }

}
