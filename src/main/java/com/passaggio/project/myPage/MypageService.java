package com.passaggio.project.myPage;

import com.passaggio.project.models.login.LoginService;
import com.passaggio.project.user.Delay;

import java.util.Scanner;

public class MypageService {
        public void showMypage(String userId) {
            Scanner sc = new Scanner(System.in);

            LoginService loginService = new LoginService();
            String userNickName = loginService.WhatIsNickName(userId);

            // 마이페이지 화면
            System.out.println(userId + "님 "+ userNickName +"페이지에 오신 것을 환영합니다!");

            do {
                System.out.println("================================");
                System.out.println("1. 전체 플레이리스트 조회");
                System.out.println("2. 개인 플레이리스트 조회");
                System.out.println("9. 로그아웃");
                System.out.println("================================");
                Delay.countdelay(1000);

                int whatPLchoice = sc.nextInt();
                if(whatPLchoice == 1) {

                } else if(whatPLchoice == 2) {

                } else if (whatPLchoice == 9) {
                    System.out.println("================================");
                    System.out.println("로그아웃 중입니다. 잠시만 기다려주세요.");
                    System.out.println("================================");
                    System.out.println();
                    break;
                }
            }while(true);
            Delay.countdelay(1000);
        }
    }
