package com.passaggio.project.view.login;


import com.passaggio.project.controller.LoginController;
import com.passaggio.project.myPage.MypageService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


    public class Login {

            public static Map<String, String> inputMenu(){
                Scanner sc = new Scanner(System.in);

                String id;

                //아이디 입력 및 아이디 일치 확인
                do {
                    System.out.print("아이디를 입력해주세요: ");
                    id = sc.nextLine();
                    if (!(LoginController.matchId(id))) {
                        System.out.println("================================");
                        System.out.println("아이디가 일치하지 않습니다. 다시 입력해주세요");
                        System.out.println("================================");
                    }
                } while (!LoginController.matchId(id)); // 일치하지 않는 아이디가 입력될 경우 계속 실행

                System.out.print("비밀번호를 입력하세요: ");
                String pwd = sc.nextLine();

                Map<String, String> parameter = new HashMap<>();

                parameter.put("userId", id);
                parameter.put("userPwd", pwd);

                return parameter;
            }



    }

