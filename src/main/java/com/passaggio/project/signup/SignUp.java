package com.passaggio.project.signup;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;
import java.util.Timer;

public class SignUp {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        Scanner sc = new Scanner(System.in);
        boolean WrongNum = true;

        while(WrongNum) {

            //만약 1번을 선택하면 로그인창으로 이동하게
            //2번을 선택한다면 회원가입창으로
            System.out.println("계정이 있으십니까?");
            System.out.println("1. 예(로그인 창으로 이동됩니다.)");
            System.out.println("2. 아니요(회원가입으로 이동됩니다.)");
            System.out.println("================================");
            System.out.print("--> ");
            String loginNumString = sc.next();          // 숫자 입력 시에 오류가 나지 않게 하기 위해서 일부러 입력을 String으로 받음

            try{
                int loginNum = Integer.parseInt(loginNumString);        //String을 숫자로 변환함

                if (loginNum == 1) {
                    //여기에 로그인 기능 구현


                    WrongNum = false;
                } else if (loginNum == 2) {

                    try {
                        System.out.println("회원 가입을 시작합니다.");

                        System.out.print("회원번호를 입력해주세요: ");
                        int seq = sc.nextInt();

                        System.out.print("아이디를 입력해주세요: ");
                        sc.nextLine();
                        String id = sc.nextLine();

                        System.out.print("비밀번호를 입력해주세요: ");
                        String pwd = sc.nextLine();

                        System.out.print("성별(M/F)을 입력해주세요: ");
                        char gender = sc.next().charAt(0);

                        SignUpDTO signUpDTO = new SignUpDTO(seq, id, pwd, gender);      //signup객체생성

                        // 데이터베이스 연결
                        try (Connection conn = DatabaseConnection.getConnection()) {
                            String sql = "INSERT INTO member (seq, id, pwd, gender) VALUES (?, ?, ?, ?)";

                            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                                pstmt.setInt(1, signUpDTO.getSeq());                            // ? 1번
                                pstmt.setString(2, signUpDTO.getId());                          // ? 2번
                                pstmt.setString(3, signUpDTO.getPwd());                         // ? 3번
                                pstmt.setString(4, String.valueOf(signUpDTO.getGender()));      // ? 4번

                                int result = pstmt.executeUpdate();
                                if (result > 0) {
                                    System.out.println("회원 가입에 성공했습니다.");
                                } else {
                                    System.out.println("회원 가입에 실패했습니다.");
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        sc.close();
                    }
                } else {
                    System.out.println("번호를 잘못 입력하였습니다.");
                    System.out.println("3초 뒤에 처음 화면으로 돌아갑니다.");
                    System.out.println("================================");
                    System.out.println();
                    Delay.countdelay(3000);
                }

            }catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
                System.out.println("3초 뒤에 처음 화면으로 돌아갑니다.");
                System.out.println("================================");
                System.out.println();
                Delay.countdelay(3000);
            }
        }


    }

}
