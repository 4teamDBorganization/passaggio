package com.passaggio.project.view.signup;

import com.passaggio.project.models.signup.SignUpDTO;
import com.passaggio.project.view.login.Login;

import java.util.Scanner;
import java.util.Timer;

public class SignUp {

    public static void userCheck() {
        Scanner sc = new Scanner(System.in);
        Timer timer = new Timer();
        int loginNum = sc.nextInt();


            //int loginNum = Integer.parseInt(loginNumString);        //String을 숫자로 변환함

            if (loginNum == 1) {
                Login loginService = new Login();
                loginService.login();

//                    WrongNum = false;
            } else if (loginNum == 2) {


                System.out.println("회원 가입을 시작합니다.");

                System.out.print("회원번호를 입력해주세요: ");
                int seq = sc.nextInt();

                System.out.print("아이디를 입력해주세요: ");
                sc.nextLine();
                String id = sc.nextLine();

                System.out.print("비밀번호를 입력해주세요: ");
                String pwd = sc.nextLine();

                System.out.print("닉네임을 입력해주세요: ");
                String nick = sc.nextLine();

                System.out.print("성별(M/F)을 입력해주세요: ");
                char gender = sc.next().charAt(0);

                SignUpDTO signUpDTO = new SignUpDTO(seq, id, pwd, nick, gender);      //signup객체생성

                // 데이터베이스 연결

//                            int result = pstmt.executeUpdate();
//                            if (result > 0) {
//                                System.out.println("회원 가입에 성공했습니다.");
////                                return false;
//                            } else {
//                                System.out.println("회원 가입에 실패했습니다.");
//                            }
            }
        }

}


