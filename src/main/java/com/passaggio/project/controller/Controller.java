package com.passaggio.project.controller;

import com.passaggio.project.model.listcontent.ListContentService;
import com.passaggio.project.model.listcontent.ListContentTO;
import com.passaggio.project.model.playlist.PlaylistService;
import com.passaggio.project.model.playlist.PlaylistTO;
import com.passaggio.project.model.songinfo.SongInfoService;
import com.passaggio.project.model.songinfo.SongInfoTO;
import com.passaggio.project.view.PlaylistViews;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    private final PlaylistViews views;
    private final PlaylistService plService;
    private final ListContentService lcService;
    private final SongInfoService siService;

    private int loggedInUserSeq;

    public Controller(){
        views = new PlaylistViews();

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
        boolean flag;
        do{
            flag = false;
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("mseq", loggedInUserSeq);

            List<PlaylistTO> plList = plService.selectAllList();
            parameter.put("plList", plList);

            views.wholeList(parameter);

            int page = (Integer)parameter.get("page");

            switch(page){
                case 0:
                    flag = true;
                    break;
                case 1:
                    viewList(parameter);
                    break;
            }
        }while(!flag);
    }

    public void myPage() {

        boolean flag;
        do{
            flag = false;
            List<PlaylistTO> plList = plService.selectUserPlList(loggedInUserSeq);

            Map<String, Object> parameter = new HashMap<>();
            parameter.put("mseq", loggedInUserSeq);
            parameter.put("plList", plList);

            views.myPage(parameter);
            int page = (Integer)parameter.get("page");

            switch (page) {
                // 뒤로가기
                case 0:
                    flag = true;
                    break;
                // 리스트 조회
                case 1:
                    viewList(parameter);
                    break;
                // 리스트 추가
                case 2:
                    registerList();
                    break;
                // 리스트 수정
                case 3:
                    modifyList(parameter);;
                    break;
                // 리스트 삭제
                case 4:
                    deleteList(parameter);;
                    break;
                default:
            }
        } while(!flag);
    }

    public void viewList(Map<String, Object> parameter) {
        PlaylistTO pto = (PlaylistTO)parameter.get("selectedList");

        boolean flag;
        do{
            flag = false;
            int mseq = pto.getMseq();
            int loggedInSeq = (Integer)parameter.get("mseq");

            boolean isMaster = (mseq == loggedInSeq);
            int lseq = pto.getSeq();

            List<SongInfoTO> infoList = siService.selectSongsInContents2(lseq);

            parameter.put("isMaster", isMaster);
            parameter.put("lseq", lseq);
            parameter.put("infoList", infoList);

            views.viewList(parameter);

            switch((Integer)parameter.get("page")){
                case 0:     // 0 - 뒤로가기 > do-while 탈출
                    flag = true;
                    break;

                case 1:     // 1 - 노래재생
                    playSong(parameter);
                    break;

                case 2:     // 2 - 노래추가
                    addSong(lseq);
                    break;

                case 3:     // 3 - 노래삭제
                    dropSong(parameter);
                    break;

                default:
            }
        }while(!flag);

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

        // 새로운 데이터 > (seq = auto_increment된 sseq값이 파라미터로 INSERT문에 전달한 sto의 seq에 저장됨)
        if(checkInfo == null){
            // song_info INSERT 결과 > flag 설정 (true - 비정상 / false - 정상)
            int result = siService.insertSongInfo(sto);
            if(result != 1){
                flag = true;
            }else{
                sseq = sto.getSeq();
            }
            // 이미 DB에 저장된 노래 > (sseq = 이미 존재하는 Info seq)
        }else{
            sseq = checkInfo.getSeq();
        }

        // song_info INSERT 성공 & 이미 존재하는 경우
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


    public void dropSong(Map<String, Object> parameter){
        views.dropSong(parameter);

        boolean flag = true;
        if((boolean)parameter.get("isDropped")){
            ListContentTO lto = (ListContentTO)parameter.get("selectedContent");

            int result = lcService.deleteContent(lto);
            if(result == 1){
                flag = false;
            }

            dropSongOk(flag);
        }

    }

    public void dropSongOk(boolean flag){
        views.dropSongOk(flag);
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


    private void modifyList(Map<String, Object> parameter) {

        views.modifyList(parameter);

        PlaylistTO pto = null;

        boolean flag = false;
        if((boolean)parameter.get("isModified")){
            pto = (PlaylistTO)parameter.get("selectedList");
            int result = plService.modifyPlaylist(pto);
            if(result != 1){
                flag = true;
            }

            modifyListOk(flag);
        }
    }

    private void modifyListOk(boolean flag) {
        views.modifyListOk(flag);
    }


    private void deleteList(Map<String, Object> parameter) {

        int lseq = ((PlaylistTO)parameter.get("selectedList")).getSeq();

        List<SongInfoTO> infoList = siService.selectSongsInContents2(lseq);
        int count = infoList != null ? infoList.size() : 0;

        parameter.put("infoList", infoList);

        views.deleteList(parameter);

        boolean flag = false;
        if((boolean)parameter.get("isDeleted")){

            int result = lcService.deleteContents(lseq, count);

            if(result == count){
                result = plService.deletePlaylist(lseq);

                if(result != 1){
                    flag = true;
                }

            }else{
                flag = true;
            }
            deleteListOk(flag);
        }

    }

    private void deleteListOk(boolean flag) {
        views.deleteListOk(flag);
    }
}
