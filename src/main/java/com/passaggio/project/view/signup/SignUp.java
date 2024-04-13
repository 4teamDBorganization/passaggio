package com.passaggio.project.view.signup;

import com.passaggio.project.controller.SignUpController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SignUp {

    public static Map<String, String> inputMenu() {
        Scanner sc = new Scanner(System.in);

        SignUpController signUpController = new SignUpController();
        Map<String, String> parameter = new HashMap<>();

        String id;
        String pwd;
        String gender;
        String nick;

        //아이디 입력 및 중복 확인
        do {
            System.out.print("아이디를 입력해주세요: ");
            id = sc.nextLine();
            if (signUpController.checkIdDuplicate(id)) {
                System.out.println("================================");
                System.out.println("이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요.");
                System.out.println("================================");
            }
        } while (signUpController.checkIdDuplicate(id)); // 중복되는 아이디가 입력될 경우 반복

        //비밀번호 입력 및 조건 추가
        do {
            System.out.print("비밀번호를 입력해주세요 (특수문자, 영문자 포함 6글자 이상): ");
            pwd = sc.nextLine();
            if (!isValidPassword(pwd)) {
                System.out.println("비밀번호는 특수문자, 영문자를 포함하고 6글자 이상이어야 합니다. 다시 입력해주세요.");
            }
        } while (!isValidPassword(pwd)); // 조건을 만족하지 않는 경우 반복

        //닉네임 입력 및 중복 확인
        do {
            System.out.print("닉네임을 입력해주세요: ");
            nick = sc.nextLine();

            if (signUpController.checkNick(nick)) {
                System.out.println("================================");
                System.out.println("이미 사용 중인 닉네임입니다. 다른 닉네임을 입력해주세요.");
                System.out.println("================================");
            }
        } while (signUpController.checkNick(nick)); // 중복되는 닉네임이 입력될 경우 반복

        //성별 입력 및 오류 잡기
        do {
            System.out.print("성별(M/F)을 입력해주세요: ");
            gender = sc.nextLine().toUpperCase(); // 입력된 성별을 대문자로 변환하여 비교
            if (!gender.equals("M") && !gender.equals("F")) {
                System.out.println("잘못된 입력입니다. 'M' 또는 'F'로 입력해주세요.");
            }
        } while (!gender.equals("M") && !gender.equals("F")); // 유효하지 않은 성별이 입력된 경우 반복

        parameter.put("userId", id);
        parameter.put("userPwd", pwd);
        parameter.put("userNickName", nick);
        parameter.put("userGender", gender);

        return parameter;
    }

    private static boolean isValidPassword(String password) {
        // 비밀번호는 특수문자, 영문자를 포함하고 6글자 이상이어야 함
        return password.matches("^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()-+=]).{6,}$");
    }
}
