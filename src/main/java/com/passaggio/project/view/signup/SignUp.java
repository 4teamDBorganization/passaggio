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
//        System.out.print("회원번호를 입력해주세요: ");
//        String seq = sc.nextLine();

        System.out.print("아이디를 입력해주세요: ");
        String id = sc.nextLine();

        System.out.print("비밀번호를 입력해주세요: ");
        String pwd = sc.nextLine();

        System.out.print("닉네임을 입력해주세요: ");
        String nick = sc.nextLine();

        System.out.print("성별(M/F)을 입력해주세요: ");
        String gender = sc.nextLine();
//        char gender = sc.next().charAt(0);

        Map<String, String> parameter = new HashMap<>();

//        parameter.put("userCode", seq);
        parameter.put("userId", id);
        parameter.put("userPwd", pwd);
        parameter.put("userNickName", nick);
        parameter.put("userGender", gender);

        return parameter;
    }

}


