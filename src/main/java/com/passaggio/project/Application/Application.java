package com.passaggio.project.Application;

import com.passaggio.project.controller.LoginController;
import com.passaggio.project.controller.SignUpController;
import com.passaggio.project.myPage.MypageService;
import com.passaggio.project.view.login.Login;
import com.passaggio.project.view.lostaccount.LostAccount;
import com.passaggio.project.view.signup.SignUp;

import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class Application {
    public static void main(String[] args) {

        LoginController loginController = new LoginController();
        SignUpController signUpController = new SignUpController();
        MypageService mypageService = new MypageService();

        boolean ing = true;
        Scanner sc = new Scanner(System.in);

        //만약 1번을 선택하면 로그인창으로 이동하게
        //2번을 선택한다면 회원가입창으로
        while (ing) {
            System.out.println("================================");
            System.out.println("계정이 있으십니까?");
            System.out.println("1. 예(로그인 창으로 이동됩니다.)");
            System.out.println("2. 아니요(회원가입으로 이동됩니다.)");
            System.out.println("3. 아이디와 비밀번호를 잊었습니다.");
            System.out.println("4. 종료하기");
            System.out.println("================================");
            System.out.print("--> ");
            int choose = sc.nextInt();

            if (choose == 1) {
                Login loginService = new Login();
                Map<String, String> loginInfo = loginService.inputMenu();
                loginController.goLogin(loginInfo);
                String userId = loginInfo.get("userId");
                mypageService.showMypage(userId);
//                ing = false;
            } else if (choose == 2) {
                System.out.println("회원 가입을 시작합니다.");
                Map<String, String> signUpInfo = SignUp.inputMenu();
                signUpController.registerSignUp(signUpInfo);
            }else if(choose == 3){
                LostAccount lostAccount = new LostAccount();
                lostAccount.findaccount();
            }else if (choose == 4){
                System.out.println("프로그램을 종료합니다.");
                exit(0);
            }


        }
//        mypageService.showMypage();

    }


}
