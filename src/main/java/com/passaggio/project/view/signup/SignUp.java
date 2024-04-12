package com.passaggio.project.view.signup;

import com.passaggio.project.controller.SignUpController;
import com.passaggio.project.models.signup.SignUpDTO;
import com.passaggio.project.view.login.Login;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;

public class SignUp {

    public static Map<String, String> inputMenu(){
        Scanner sc = new Scanner(System.in);

        SignUpController signUpController = new SignUpController();
        Map<String, String> parameter = new HashMap<>();

        String id;
        do {
            System.out.print("아이디를 입력해주세요: ");
            id = sc.nextLine();
            if (signUpController.checkIdDuplicate(id)) {
                System.out.println("================================");
                System.out.println("이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요.");
                System.out.println("================================");
            }
        } while (signUpController.checkIdDuplicate(id)); // 중복되는 아이디가 입력될 경우 반복
        parameter.put("userId", id);

        System.out.print("비밀번호를 입력해주세요: ");
        String pwd = sc.nextLine();

        System.out.print("닉네임을 입력해주세요: ");
        String nick = sc.nextLine();

        System.out.print("성별(M/F)을 입력해주세요: ");
        String gender = sc.nextLine();

        parameter.put("userId", id);
        parameter.put("userPwd", pwd);
        parameter.put("userNickName", nick);
        parameter.put("userGender", gender);

        return parameter;
    }

}


