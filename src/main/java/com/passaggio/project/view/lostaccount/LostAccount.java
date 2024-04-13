package com.passaggio.project.view.lostaccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LostAccount {

    public static Map<String, String> findaccount(){
        LostAccountService lostAccountService = new LostAccountService();
        Map<String, String> parameter = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int pnum;
        String pnick;
        String pgender;

        System.out.println("1. 아이디를 잊어버렸습니다.");
        System.out.println("2. 비밀번호를 잊어버렸습니다.");
        System.out.println("9. 처음으로 돌아가기");
        int choice = sc.nextInt();


            if(choice == 1) {
                do{
                    System.out.println("================================");
                    System.out.println("아이디 찾기를 시작합니다.");
                    System.out.println("필요한 정보를 기입해주세요.");
                    System.out.println("================================");
                    System.out.println("회원고유번호를 입력해주세요.");
                    pnum = sc.nextInt();
                    System.out.println("닉네임을 입력해주세요.");
                    pnick = sc.next();
                    System.out.println("성별을 입력해주세요.");
                    pgender = sc.next();

                    parameter.put("seq", String.valueOf(pnum));
                    parameter.put("nick", pnick);
                    parameter.put("gender", pgender);

                    if (!(LostController.findid(pnum, pnick, pgender))) {
                        System.out.println("================================");
                        System.out.println("일치하지 않습니다.");
                        System.out.println("================================");
                        System.out.println("1. 다시 시도하시겠습니까?");
                        System.out.println("2. 처음화면으로 돌아가겠습니다.");
                        System.out.println("================================");
                        int gohome = sc.nextInt();
                        if(gohome == 1) {

                        }
                        else if(gohome == 2) {
                            break;
                        }
                    }else {
                        System.out.println("================================");
                        System.out.println("일치합니다.");
                        System.out.println("================================");
                    }
                }while(true);

//                System.out.println("탈출~");



            }else if(choice == 2){

        }else if(choice == 9){

        }


        return parameter;
    }

}
