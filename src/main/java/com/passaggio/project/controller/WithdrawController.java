package com.passaggio.project.controller;

import com.passaggio.project.model.withdraw.WithdrawService;

public class WithdrawController {
    public static void deleteUser(String id) {
        if (WithdrawService.deleteUser(id)) {
            System.out.println("회원 탈퇴가 완료되었습니다.");
        } else {
            System.out.println("회원 탈퇴에 실패하였습니다.");
        }
    }
}
