package com.passaggio.project.Application;

import com.passaggio.project.controller.LoginController;
import com.passaggio.project.controller.SignUpController;
import com.passaggio.project.view.login.Login;
import com.passaggio.project.view.signup.SignUp;

import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        LoginController loginController = new LoginController();
        SignUpController signUpController = new SignUpController();

        Scanner sc = new Scanner(System.in);

        //만약 1번을 선택하면 로그인창으로 이동하게
        //2번을 선택한다면 회원가입창으로
        while (true) {
            System.out.println("계정이 있으십니까?");
            System.out.println("1. 예(로그인 창으로 이동됩니다.)");
            System.out.println("2. 아니요(회원가입으로 이동됩니다.)");
            System.out.println("3. 종료하기");
            System.out.println("================================");
            System.out.print("--> ");
            int choose = sc.nextInt();

            //String loginNumString = sc.next();          // 숫자 입력 시에 오류가 나지 않게 하기 위해서 일부러 입력을 String으로 받음

            if (choose == 1) {
                Login loginService = new Login();
                Map<String, String> loginInfo = loginService.inputMenu();
                loginController.goLogin(loginInfo);

            } else if (choose == 2) {
                System.out.println("회원 가입을 시작합니다.");
                Map<String, String> signUpInfo = SignUp.inputMenu();
                signUpController.registerSignUp(signUpInfo);
//                System.out.println("회원 가입이 완료되었습니다.");
            }else if (choose == 3){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

    }


}
