package com.passaggio.project.controller;

import com.passaggio.project.model.listcontent.ListContentService;
import com.passaggio.project.model.listcontent.ListContentTO;
import com.passaggio.project.model.playlist.PlaylistService;
import com.passaggio.project.model.playlist.PlaylistTO;
import com.passaggio.project.model.songinfo.SongInfoService;
import com.passaggio.project.model.songinfo.SongInfoTO;
import com.passaggio.project.view.Views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    private final Views views;
    private final PlaylistService plService;
    private final ListContentService lcService;
    private final SongInfoService siService;

    private int loggedInUserSeq;

    public Controller(){
        views = new Views();
        plService = new PlaylistService();
        lcService = new ListContentService();
        siService = new SongInfoService();
        loggedInUserSeq = 1; // 임시
    }

    public boolean logIn(Map<String, String> loginInfo){

        loggedInUserSeq = 1;
        return true;
    }

    public boolean logOut() {

        loggedInUserSeq = 0;
        return false;
    }

    public void wholeList(){
        List<PlaylistTO> plList = plService.selectAllList();

        views.wholeList(plList);
    }

    public void myPage() {
        List<PlaylistTO> plList = plService.selectUserPlList(loggedInUserSeq);

        Map<String, Integer> parameter = views.myPage(plList);
        int page = parameter.get("page");

        switch (page) {
            case 0: break;
            case 1: registerList(); break;
            case 2: deleteList();; break;
            case 3: modifyList();; break;
            case 4:
                PlaylistTO pto = plList.get(parameter.get("selectedIndex"));
                viewList(pto);
                break;
            default:
        }
    }

    public void registerList() {

        PlaylistTO pto = new PlaylistTO();

        views.registerList(loggedInUserSeq, pto);

        // SQL 응답 updateCount에 따라 flag 설정 (true - 비정상 / false - 정상)
        boolean flag = false;
        int result = plService.insertPlaylist(pto);
        if(result == 0){
            flag = true;
        }

        registerListOk(flag);
    }

    public void registerListOk(boolean flag) {

        views.registerListOk(flag);

    }

    private void deleteList() {
    }

    private void modifyList() {
    }

    public void viewList(PlaylistTO pto) {
        boolean flag = false;

        do{
            flag = false;
            Map<String, Object> parameter = new HashMap<>();
            int lseq = pto.getSeq();

            // 플레이리스트 seq를 통해 list_content 테이블에서 노래 seq 리스트 로드
            List<Integer> contents = lcService.selectContentsByLseq(lseq);

            List<SongInfoTO> infos = new ArrayList<>();
            // 노래 seq 리스트를 통해 song_info 테이블에서 노래 정보 리스트 로드
            if(contents != null && !contents.isEmpty()){
                infos = siService.selectSongsInContents(contents);
            }

            parameter = views.viewList(pto, infos);

            switch((Integer)parameter.get("page")){
                case 0:     // 0 - 뒤로가기 > do-while 탈출
                    flag = true;
                    break;

                case 1:     // 1 - 노래재생
                    parameter.put("infos", infos);
                    playSong(parameter);
                    break;

                case 2:     // 2 - 노래추가
                    addSong(lseq);
                    break;

                case 3:     // 3 - 노래삭제
//                    deleteSong();
                    break;

                default:
            }
        }while(flag);
        
    }

    public void playSong(Map<String, Object> parameter){

        views.playSong(parameter);

    }

    public void addSong(int lseq){

        SongInfoTO sto = views.addSong();

        boolean flag = false;
        int sseq = 0;

        // 크롤링 실패
        if(sto.getLink() == null){
            addSongOk(true);
            return;
        }

        // 중복 체크 : DB상에 같은 가수-제목 데이터 존재 여부
        SongInfoTO checkInfo = siService.selectSongByInfo(sto);

        // 새로운 데이터(sseq = auto_increment 값) || 중복 데이터(sseq = 이미 존재하는 Info seq)
        if(checkInfo == null){
            // song_info INSERT 결과 > flag 설정 (true - 비정상 / false - 정상)
            int result = siService.insertSongInfo(sto);
            if(result != 1){
                flag = true;
            }else{
                sseq = sto.getSeq();
            }

        }else{
            sseq = checkInfo.getSeq();
        }

        // song_info INSERT 성공 or 이미 존재하는 경우
        // list_content INSERT
        if(!flag){

            ListContentTO lto = new ListContentTO();
            lto.setLseq(lseq);
            lto.setSseq(sseq);

            // list_content INSERT 결과 > flag 설정 (true - 비정상 / false - 정상)
            int result = lcService.insertContent(lto);
            if(result != 1){
                flag = true;
            }
        }

        addSongOk(flag);
    }

    public void addSongOk(boolean flag){

        views.addSongOk(flag);

    }

    public void plView(int lseq){
    }

}
