package com.passaggio.project.view.withdraw;

import com.passaggio.project.controller.LoginController;
import com.passaggio.project.controller.WithdrawController;

import java.util.Scanner;

public class Withdraw {
    public void withdrawal() {
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요: ");
        String id = sc.next();
        System.out.print("비밀번호를 입력하세요: ");
        String pwd = sc.next();

        if (LoginController.matchId(id) && LoginController.matchPwd(id, pwd)) {
            System.out.println("회원 탈퇴를 진행합니다. 정말 탈퇴하시겠습니까? (Y or N)");
            String confirm = sc.next();
            if (confirm.equalsIgnoreCase("Y")) {
                WithdrawController.deleteUser(id);
                System.out.println("회원 탈퇴가 완료되었습니다.");
            } else if (confirm.equalsIgnoreCase("N")) {
                System.out.println("회원 탈퇴를 취소합니다.");
            } else {
                System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
            }
        } else {
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다. 회원 탈퇴를 진행할 수 없습니다.");
        }
    }
}
