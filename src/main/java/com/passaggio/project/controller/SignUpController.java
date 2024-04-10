package com.passaggio.project.controller;

import com.passaggio.project.models.signup.SignUpDTO;
import com.passaggio.project.models.signup.SignUpService;
import com.passaggio.project.view.signup.SignUp;

import java.util.Map;

public class SignUpController {
    public final SignUp signUp;
    public final SignUpService signUpService;

    public SignUpController(){
        signUp =new SignUp();
        signUpService = new SignUpService();

    }

    public boolean checkIdDuplicate(String userId) {
        return signUpService.isIdAlreadyInUse(userId);
    }


    public void registerSignUp(Map<String, String> parameter) {

        int userCode = Integer.parseInt(parameter.get("userCode"));
        String userId = parameter.get("userId");
        if (checkIdDuplicate(userId)) {
            System.out.println("이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요.");
            return;
        }
        String userPwd = parameter.get("userPwd");
        String userNickName = parameter.get("userNickName");
        char userGender = parameter.get("userGender").charAt(0);

        SignUpDTO signUpDTO = new SignUpDTO();
        signUpDTO.setSeq(userCode);
        signUpDTO.setId(userId);
        signUpDTO.setPwd(userPwd);
        signUpDTO.setNick(userNickName);
        signUpDTO.setGender(userGender);

        signUpService.registerUser(signUpDTO);

        System.out.println("회원가입이 완료되었습니다.");
    }
}
