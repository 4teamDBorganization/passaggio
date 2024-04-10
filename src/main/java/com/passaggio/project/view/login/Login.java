package com.passaggio.project.view.login;


import com.passaggio.project.myPage.MypageService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


    public class Login {
        public void login() {
            Scanner sc = new Scanner(System.in);

            System.out.print("아이디를 입력하세요: ");
            String id = sc.nextLine();

            System.out.print("비밀번호를 입력하세요: ");
            String pwd = sc.nextLine();


        }
    }

