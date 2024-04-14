package com.passaggio.project.myPage;

import com.passaggio.project.controller.Controller;
import com.passaggio.project.model.login.LoginService;
import com.passaggio.project.delay.Delay;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MypageService {
        public void showMypage(String userId) {
            Scanner sc = new Scanner(System.in);

            LoginService loginService = new LoginService();
            String userNickName = loginService.WhatIsNickName(userId);

            // 마이페이지 화면
            System.out.println(userId + "님 "+ userNickName +"페이지에 오신 것을 환영합니다!");

            Controller controller = new Controller();
            int inputInt;
            do {
                inputInt = 0;

                System.out.println("\n=============== 메뉴 관리 ===============");
                System.out.println("1. 전체 플레이 리스트 조회");
                System.out.println("2. 마이페이지");
                System.out.println("8. 로그아웃");
                System.out.println("9. 프로그램 종료");
                System.out.println("=========================================");
                System.out.print("메뉴 관리 번호를 입력하세요 : ");

                try {
                    inputInt = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 관리 번호입니다.");
                    continue;
                }

                switch (inputInt) {
                    case 1:
                        controller.wholeList(); break;
                    case 2:
                        controller.myPage(); break;
                    case 8:
                        break;
                    case 9:
                        controller.logOut();
                        sc.close();
                        System.out.println("메뉴 관리 프로그램을 종료합니다.");
                        Delay.countdelay(1000);
                        return;
                    default:
                        System.out.println("잘못된 관리 번호입니다.");
                        break;
                }

//                System.out.println("================================");
//                System.out.println("1. 전체 플레이리스트 조회");
//                System.out.println("2. 개인 플레이리스트 조회");
//                System.out.println("9. 로그아웃");
//                System.out.println("================================");
//                Delay.countdelay(1000);
//
//                int whatPLchoice = sc.nextInt();
//                if(whatPLchoice == 1) {
//
//                } else if(whatPLchoice == 2) {
//
//                } else if (whatPLchoice == 9) {
//                    System.out.println("================================");
//                    System.out.println("로그아웃 중입니다. 잠시만 기다려주세요.");
//                    System.out.println("================================");
//                    System.out.println();
//                    break;
//                }
            }while(true);

        }
    }
