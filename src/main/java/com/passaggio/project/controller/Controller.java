package com.passaggio.project.controller;

import com.passaggio.project.model.playlist.PlaylistService;
import com.passaggio.project.model.playlist.PlaylistTO;
import com.passaggio.project.view.Views;

import java.util.List;
import java.util.Map;

public class Controller {

    private final Views views;
    private final PlaylistService plService;

    private int loggedInUserSeq;

    public Controller(){
        views = new Views();
        plService = new PlaylistService();
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
            case 4: viewList();; break;
            default:
        }
    }

    private void registerList() {

        PlaylistTO pto = new PlaylistTO();

        views.registerList(loggedInUserSeq, pto);
        boolean flag = false;

        int result = plService.insertPlaylist(pto);
        if(result == 0){
            flag = true;
        }

        registerListOk(flag);
    }

    private void registerListOk(boolean flag) {

        views.registerListOk(flag);

    }

    private void deleteList() {
    }

    private void modifyList() {
    }

    private void viewList() {
    }

    public void plView(int lseq){

    }
}
