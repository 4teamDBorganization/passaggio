package com.passaggio.project.view.withdraw;

import com.passaggio.project.controller.LoginController;
import com.passaggio.project.controller.WithdrawController;
import com.passaggio.project.delay.Delay;

import java.util.Scanner;

public class Withdraw {
    public void withdrawal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n================= <회원탈퇴> =================");
        System.out.println("아이디를 입력하세요: ");
        System.out.print("--> ");
        String id = sc.next();
        System.out.println("비밀번호를 입력하세요: ");
        System.out.print("--> ");
        String pwd = sc.next();
        System.out.println("=============================================");
        Delay.countdelay(1000);
        System.out.println();
        System.out.println("아이디가 일치하는지 확인 중입니다. 잠시만 기다려주세요.");
        Delay.countdelay(1000);
        System.out.println("............................");
        Delay.countdelay(1000);
        System.out.println("..................");
        Delay.countdelay(1000);
        System.out.println(".........");
        Delay.countdelay(1000);
        System.out.println("..");
        Delay.countdelay(1000);

        if (LoginController.matchId(id) && LoginController.matchPwd(id, pwd)) {
            System.out.println("\n================= <회원탈퇴> =================");
            System.out.println("확인되었습니다.");
            System.out.println("회원 탈퇴를 진행합니다. 정말 탈퇴하시겠습니까? (Y or N)");
            System.out.print("--> ");
            String confirm = sc.next();
            if (confirm.equalsIgnoreCase("Y")) {
                WithdrawController.deleteUser(id);
                Delay.countdelay(1000);
            } else if (confirm.equalsIgnoreCase("N")) {
                System.out.println("회원 탈퇴를 취소합니다.");
                Delay.countdelay(1000);
            } else {
                System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
                Delay.countdelay(1000);
            }
        } else {
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다. 회원 탈퇴를 진행할 수 없습니다.");
            Delay.countdelay(1000);
        }
    }
}
