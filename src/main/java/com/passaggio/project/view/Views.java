package com.passaggio.project.view;

import com.passaggio.project.model.playlist.PlaylistTO;

import java.util.*;

public class Views {

    public void wholeList(List<PlaylistTO> plList){

        if(plList != null){

            for(PlaylistTO pto : plList){
                System.out.println(pto.toString());
            }

        }else{

            System.out.println("현재 등록된 플레이리스트가 없습니다.");

        }
    }

    public Map<String, Integer> myPage(List<PlaylistTO> plList){
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> parameter = new HashMap<>();

        int lseq = 0;

        int no = 0;
        boolean flag = false;

        if(plList != null){

            flag = false;

            for(int i = 0; i < plList.size(); i++){
                System.out.println("번호 " + (i + 1) + " : " + plList.get(i).toString());
            }

            do{
                System.out.println("=============================");
                System.out.println("0. 뒤로 가기");
                System.out.println("1. 플레이리스트 추가");
                System.out.println("2. 플레이리스트 삭제");
                System.out.println("3. 플레이리스트 수정");
                System.out.println("4. 플레이리스트 조회");
                System.out.println("=============================");
                System.out.print("메뉴 번호를 입력하세요 : ");

                try {
                    no = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("올바른 메뉴 번호가 아닙니다.");
                    flag = true;
                    continue;
                } finally {
                    sc.nextLine();
                }

                switch (no) {
                    case 0: parameter.put("page", 0); break;
                    case 1: parameter.put("page", 1); break;
                    case 2: parameter.put("page", 2);; break;
                    case 3: parameter.put("page", 3);; break;
                    case 4: parameter.put("page", 4);; break;
                    default:
                        System.out.println("올바른 메뉴 번호가 아닙니다.");
                        flag = true;
                }
//                try {
//                    no = sc.nextInt();
//                } catch (InputMismatchException e) {
//                    System.out.println("번호를 입력해주세요");
//                    continue;
//                } finally {
//                    sc.nextLine();
//                }
//
//                if(no != 0){
//
//                    try {
//                        lseq = plList.get(no - 1).getSeq();
//
//                        flag = true;
//                    } catch (IndexOutOfBoundsException e) {
//                        System.out.println("해당하는 번호의 플레이리스트가 존재하지 않습니다.");
//                    }
//
//                }else{
//                    flag = true;
//                }
            } while(flag);

        }else{

            parameter.put("page", 0);

            System.out.println("현재 등록된 플레이리스트가 없습니다.");

        }

        sc = null;
        return parameter;
    }

    public void registerList(int mseq, PlaylistTO pto){
        Scanner sc = new Scanner(System.in);

        String lname = null;
        String exp = null;

        System.out.println("============= 플레이리스트 생성 =============");
        System.out.print("플레이리스트의 이름을 입력하세요 : ");
        lname = sc.nextLine();
        System.out.print("설명을 입력하세요(미입력 - 공백입력) : ");
        exp = sc.nextLine();

        pto.setMseq(mseq);
        if(!exp.isBlank()){
            pto.setExp(exp);
        }
        pto.setLname(lname);
    }

    public void registerListOk(boolean flag){

        if(!flag){
            System.out.println("플레이리스트 생성 완료");
        }else{
            System.out.println("플레이리스트 생성 실패");
        }

    }
}
