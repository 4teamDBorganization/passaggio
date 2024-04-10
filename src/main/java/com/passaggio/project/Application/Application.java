package com.passaggio.project.Application;

import static com.passaggio.project.view.signup.SignUp.userCheck;

public class Application {
    public static void main(String[] args) {
        //만약 1번을 선택하면 로그인창으로 이동하게
        //2번을 선택한다면 회원가입창으로
        System.out.println("계정이 있으십니까?");
        System.out.println("1. 예(로그인 창으로 이동됩니다.)");
        System.out.println("2. 아니요(회원가입으로 이동됩니다.)");
        System.out.println("================================");
        System.out.print("--> ");
        //String loginNumString = sc.next();          // 숫자 입력 시에 오류가 나지 않게 하기 위해서 일부러 입력을 String으로 받음
        userCheck();
    }
}
