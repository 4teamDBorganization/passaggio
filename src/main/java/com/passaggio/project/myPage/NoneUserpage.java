package com.passaggio.project.myPage;

import com.passaggio.project.controller.SignUpController;
import com.passaggio.project.delay.Delay;
import com.passaggio.project.model.playlist.PlaylistService;
import com.passaggio.project.model.playlist.PlaylistTO;
import com.passaggio.project.model.signup.SignUpService;
import com.passaggio.project.view.signup.SignUp;
import org.jsoup.internal.StringUtil;

import javax.swing.text.View;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NoneUserpage {

    public void noneuser(){
        SignUpService signUpService = new SignUpService();
        SignUpController signUpController = new SignUpController();
        PlaylistService playlistService = new PlaylistService();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. 전체 플레이리스트 확인하기");
            System.out.println("2. 마이 플레이리스트 확인하기");
            System.out.println("3. 처음으로 돌아가기");
            System.out.println("=============================================");
            System.out.print("--> ");
            int noneuserchoice = sc.nextInt();
            if (noneuserchoice == 1) {
                List<PlaylistTO> pllt = playlistService.selectAllList();
                System.out.println("\n================ <전체플레이리스트> ================");
                PlaylistTO tmp = null;
                for(int i = 0; i < pllt.size(); i++){
                    tmp = pllt.get(i);
                    System.out.println("[" + (i + 1) + "] " + tmp.getLname() + (!StringUtil.isBlank(tmp.getExp()) ? " (" + tmp.getExp() + ")" : ""));
                }
                System.out.println("=============================================");

            } else if (noneuserchoice == 2) {
                System.out.println("\n============== <마이플레이리스트> ==============");
                System.out.println("이 기능은 회원가입 이후에 사용 가능한 기능입니다.");
                System.out.println("회원 가입하시겠습니까?");
                System.out.println("=============================================");
                System.out.println("1. 예");
                System.out.println("2. 아니요");
                System.out.println("=============================================");
                System.out.print("--> ");
                int YandN = sc.nextInt();
                if (YandN == 1) {
                    Map<String, String> signUpInfo = SignUp.inputMenu();
                    signUpController.registerSignUp(signUpInfo);
                    break;
                } else if (YandN == 2) {
                    System.out.println("뒤로 돌아갑니다");
                    Delay.countdelay(1000);
                }
            }
            else if(noneuserchoice == 3){
                break;
            }
        }while (true);


    }

}
