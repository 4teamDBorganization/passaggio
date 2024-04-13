package com.passaggio.project.application;

import com.passaggio.project.controller.Controller;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();

//        boolean isLoggedIn = false;
        boolean isLoggedIn = true; // 임시
        int inputInt;

        do{
            while(!isLoggedIn){
                inputInt = 0;

                System.out.println("========== 메뉴 관리 ==========");
                System.out.println("1. 로그인");
                System.out.println("2. 회원가입");
                System.out.println("9. 프로그램 종료");
                System.out.println("==============================");
                System.out.print("메뉴 관리 번호를 입력하세요 : ");

                try {
                    inputInt = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 관리 번호입니다.");
                    continue;
                } finally {
                    sc.nextLine();
                }

                switch (inputInt) {
                    case 1:
                        isLoggedIn = controller.logIn(inputLoginInfo()); break;
//                case 2: controller.signUp(inputMenuCode()); break;
                    case 9:
                        sc.close();
                        System.out.println("메뉴 관리 프로그램을 종료합니다."); return;
                    default: System.out.println("잘못된 관리 번호입니다."); break;
                }

            }

            while (isLoggedIn){
                inputInt = 0;

                System.out.println("========== 메뉴 관리 ==========");
                System.out.println("1. 전체 플레이 리스트 조회");
                System.out.println("2. 마이페이지");
                System.out.println("8. 로그아웃");
                System.out.println("9. 프로그램 종료");
                System.out.println("==============================");
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
                        isLoggedIn = controller.logOut(); break;
                    case 9:
                        controller.logOut();
                        sc.close();
                        System.out.println("메뉴 관리 프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 관리 번호입니다.");
                        break;
                }

            }

        } while(true);
    }

    private static Map<String, String> inputLoginInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요 : ");
        String pwd = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("id", id);
        parameter.put("pwd", pwd);

        return parameter;
    }
}
