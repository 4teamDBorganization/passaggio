package com.passaggio.project.controller;

import com.passaggio.project.model.signup.SignUpDTO;
import com.passaggio.project.model.signup.SignUpService;
import com.passaggio.project.delay.Delay;
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

        String yourseq = signUpService.MySeq(userId);
        System.out.println();
        System.out.println("================================");
        System.out.println("회원가입이 완료되었습니다.");
        System.out.println("당신의 고유 번호는 " + "'" + yourseq + "'" + "입니다.");
        System.out.println("나중에 아이디나 비밀번호를 찾을 때 사용되니");
        System.out.println("메모해두어 아이디나 비밀번호를 찾을 때 어려움이 없길 바랍니다.");
        System.out.println("================================");
        Delay.countdelay(5000);

        System.out.println("잠시 후에 처음 화면으로 돌아갑니다.");
        System.out.println("================================");
        System.out.println();
        Delay.countdelay(3000);

    }

}
