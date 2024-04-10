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

            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "SELECT * FROM member WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, id);

                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            String storedPwd = rs.getString("pwd");
                            if (storedPwd.equals(pwd)) {
                                System.out.println("로그인이 되었습니다.");
                                // 로그인 성공 후 마이페이지로 이동
                                MypageService mypageService = new MypageService();
                                mypageService.showMypage();
                            } else {
                                System.out.println("비밀번호가 잘못되었습니다.");
                            }
                        } else {
                            System.out.println("아이디가 잘못되었습니다.");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

