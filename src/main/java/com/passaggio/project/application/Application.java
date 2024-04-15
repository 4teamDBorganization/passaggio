package com.passaggio.project.application;

import com.passaggio.project.controller.LoginController;
import com.passaggio.project.controller.SignUpController;
import com.passaggio.project.delay.Delay;
import com.passaggio.project.myPage.MypageService;
import com.passaggio.project.myPage.NoneUserpage;
import com.passaggio.project.view.login.Login;
import com.passaggio.project.view.lostaccount.LostAccount;
import com.passaggio.project.view.signup.SignUp;
import com.passaggio.project.view.withdraw.Withdraw;

import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class Application {
    public static void main(String[] args) {

        LoginController loginController = new LoginController();
        SignUpController signUpController = new SignUpController();
        MypageService mypageService = new MypageService();
        Withdraw withdraw = new Withdraw();
        NoneUserpage noneUserpage = new NoneUserpage();

        boolean ing = true;
        Scanner sc = new Scanner(System.in);

        //만약 1번을 선택하면 로그인창으로 이동하게
        //2번을 선택한다면 회원가입창으로
        while (ing) {
            System.out.println("\n=============================================");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 아이디/비밀번호 찾기");
            System.out.println("4. 회원 탈퇴");
            System.out.println("5. 비회원 접속");
            System.out.println("9. 종료하기");
            System.out.println("=============================================");
            System.out.print("--> ");
            int choose = sc.nextInt();

            if (choose == 1) {
                Login loginService = new Login();
                Map<String, String> loginInfo = loginService.inputMenu();
                loginController.goLogin(loginInfo);
                String userId = loginInfo.get("userId");
                String mseq = loginInfo.get("mseq");
                mypageService.showMypage(mseq, userId);
//                ing = false;
            } else if (choose == 2) {
                Map<String, String> signUpInfo = SignUp.inputMenu();
                signUpController.registerSignUp(signUpInfo);
            }else if(choose == 3){
                LostAccount lostAccount = new LostAccount();
                lostAccount.findaccount();
            }else if (choose == 4) {
                withdraw.withdrawal();
            }
            else if(choose == 5) {
                System.out.println("\n================ <비회원 접속> ================");
                System.out.println("비회원으로 이용 시에는 많은 기능들을 이용하실 수 없습니다.");
                System.out.println("=============================================");
                Delay.countdelay(1000);


                noneUserpage.noneuser();

            }else if (choose == 9){
                System.out.println("프로그램을 종료합니다.");
                exit(0);
            }


        }
//        mypageService.showMypage();

    }


}
