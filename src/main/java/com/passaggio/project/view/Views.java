package com.passaggio.project.view;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.MalformedJsonException;
import com.passaggio.project.model.playlist.PlaylistTO;
import com.passaggio.project.model.songinfo.SongInfoTO;
import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.List;

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

        int inputInt = 0;
        String inputStr = "";
        boolean flag = false;

        // 플레이리스트가 한 개 이상 존재할 때
        if(plList != null){

            do{
                flag = false;

                // 사용자 플레이리스트 전체 출력
                System.out.println("=============== 마이 페이지 ===============");
                PlaylistTO tmp = null;
                for(int i = 0; i < plList.size(); i++){
                    tmp = plList.get(i);
                    System.out.println("[" + (i + 1) + "] " + tmp.getLname() + (!StringUtil.isBlank(tmp.getExp()) ? " - " + tmp.getExp() : ""));
                }

                System.out.println("===========================================");
                System.out.println("0. 뒤로 가기");
                System.out.println("1. 플레이리스트 추가");
                System.out.println("2. 플레이리스트 삭제");
                System.out.println("3. 플레이리스트 수정");
                System.out.println("4. 플레이리스트 조회");
                System.out.println("===========================================");
                System.out.print("메뉴 번호 입력 : ");


                inputStr = sc.nextLine();
                if(inputStr.length() != 1 || !Character.isDigit(inputStr.charAt(0))) {
                    System.out.println("올바른 메뉴 번호가 아닙니다.");
                    flag = true;
                    continue;
                }else{
                    inputInt = Integer.parseInt(inputStr);
                }

                switch (inputInt) {
                    // 뒤로가기
                    case 0: parameter.put("page", 0); break;
                    // 리스트 추가
                    case 1: parameter.put("page", 1); break;
                    // 리스트 삭제
                    case 2: parameter.put("page", 2); break;
                    // 리스트 수정
                    case 3: parameter.put("page", 3); break;
                    // 리스트 조회
                    case 4:
                        do{
                            flag = false;

                            System.out.print("조회할 플레이리스트 번호 입력(0 - 취소) : ");

                            try {
                                inputInt = sc.nextInt();

                                if(0 < inputInt && inputInt <= plList.size()){
                                    parameter.put("selectedIndex", inputInt - 1);
                                }else if(inputInt == 0){
                                    System.out.println("취소");
                                    flag = true;
                                    break;

                                }else{
                                    throw new InputMismatchException();

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("올바른 번호가 아닙니다.");
                                flag = true;
                            } finally {
                                sc.nextLine();
                            }

                        } while(flag);
                        parameter.put("page", 4);
                        break;
                    default:
                        System.out.println("올바른 메뉴 번호가 아닙니다.");
                        flag = true;
                }
            } while(flag);

        }else{

            parameter.put("page", 0);

            System.out.println("현재 등록된 플레이리스트가 없습니다.");

        }

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

    public Map<String, Object> viewList(PlaylistTO pto, List<SongInfoTO> infos){
        Scanner sc = new Scanner(System.in);

        Map<String, Object> parameter = new HashMap<>();

        int input = 0;
        boolean flag, flag2;

        do{
            flag = false;

            System.out.println("============= " + pto.getLname() + " =============");
            System.out.println("설명 : " + pto.getExp());

            if(infos != null && !infos.isEmpty()){
                for(int i = 0; i < infos.size(); i++){
                    System.out.println("번호 " + (i + 1) + " : " + infos.get(i));
                }

                System.out.println("=========== 메뉴 ============");
                System.out.println("0. 뒤로가기");
                System.out.println("1. 노래 재생");
                System.out.println("2. 노래 추가");
                System.out.println("3. 노래 삭제");
                System.out.println("=============================");
                System.out.print("메뉴 번호 입력 : ");

                try {
                    input = sc.nextInt(); sc.nextLine();
                    parameter.put("page", input);

                    switch(input){
                        // 뒤로 가기
                        case 0:
                            break;
                        // 노래 재생
                        case 1:
                            do{
                                flag2 = false;
                                try {
                                    System.out.print("1 - 전체 재생 / 2 - 선택 재생");
                                    input = sc.nextInt(); sc.nextLine();
                                    parameter.put("isAll", input);

                                    if(input == 0){
                                        flag = true;

                                    }else if(input == 1){
                                        System.out.println("1 - 순차 재생 / 2- 셔플 재생");
                                        input = sc.nextInt(); sc.nextLine();

                                        parameter.put("isSequential", input);

                                    }else if(input == 2){
                                        do{
                                            System.out.print("재생할 노래 번호 : ");
                                            input = sc.nextInt(); sc.nextLine();

                                            if(1 <= input && input <= infos.size()){
                                                parameter.put("songIndex", input - 1);
                                                break;
                                            }else{
                                                System.out.println("올바른 노래 번호를 입력해주세요.");
                                            }
                                        } while(true);

                                    }else{
                                        System.out.println("올바른 번호를 입력해주세요.");
                                        flag2 = true;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("올바른 번호를 입력해주세요.");
                                    flag2 = true;
                                }
                            } while(flag2);
                            break;
                        // 노래 추가
                        case 2:break;
                        // 노래 삭제
                        case 3: break;
                        // 다른 메뉴 번호 입력 시 처리
                        default:
                            System.out.println("올바른 메뉴 번호를 입력하세요.");
                            flag = true;
                    }
                    // 숫자 외 문자 입력 시 처리
                } catch (InputMismatchException e) {
                    System.out.println("올바른 메뉴 번호를 입력하세요.");
                    flag = true;
                }
            }else{
                System.out.println("[ 저장된 노래가 없습니다 ]");
                System.out.println("=========== 메뉴 ============");
                System.out.println("0. 뒤로가기");
                System.out.println("1. 노래 추가");
                System.out.println("=============================");
                System.out.print("메뉴 번호 입력 : ");

                try{
                    input = sc.nextInt(); sc.nextLine();
                    parameter.put("page", input);

                    switch(input){
                        // 뒤로 가기
                        case 0:
                            break;
                        // 노래 추가
                        case 1:
                            parameter.put("page", 2);
                            break;
                        default:
                            // 다른 메뉴 번호 입력 시 처리
                            System.out.println("올바른 메뉴 번호를 입력하세요.");
                            flag = true;
                    }
                    // 숫자 외 문자 입력 시 처리
                } catch (InputMismatchException e) {
                    System.out.println("올바른 메뉴 번호를 입력하세요.");
                    flag = true;
                }

            }

        } while(flag);

        return parameter;
    }

    public void playSong(Map<String, Object> parameter){
        @SuppressWarnings("unchecked")
        List<SongInfoTO> infos = (List<SongInfoTO>) parameter.get("infos");
        boolean isAll = (Integer)parameter.get("isAll") == 1;

        Desktop desktop = Desktop.getDesktop();

        if(isAll){
            StringJoiner sj = new StringJoiner(",");
            List<String> links = new ArrayList<>();
            for(SongInfoTO info : infos){
                links.add(info.getLink());
            }

            boolean isSequential = (Integer)parameter.get("isSequential") == 1;
            // 순차 재생
            if(isSequential){
                for(String link : links){
                    sj.add(link);
                }

                try {
                    desktop.browse(new URI("https://www.youtube.com/watch_videos?video_ids=" + sj));
                } catch (IOException | URISyntaxException e) {
                    System.out.println("[Error]Views.playSong : " + e.getMessage());
                }
                // 셔플 재생
            }else{
                Random random = new Random();
                int size = links.size();

                for(int i = 0, index; i < size; i++){
                    index = random.nextInt(size - i);

                    sj.add(links.remove(index));
                }

                try {
                    desktop.browse(new URI("https://www.youtube.com/watch_videos?video_ids=" + sj));
                } catch (IOException | URISyntaxException e) {
                    System.out.println("[Error]Views.playSong : " + e.getMessage());
                }
            }

        }else{
            SongInfoTO info = infos.get((Integer)parameter.get("songIndex"));

            try {
                desktop.browse(new URI("https://www.youtube.com/watch?v=" + info.getLink()));
            } catch (IOException | URISyntaxException e) {
                System.out.println("[Error]Views.playSong : " + e.getMessage());
            }
        }
    }

    // 노래 추가
    public SongInfoTO addSong(){
        Scanner sc = new Scanner(System.in);
        SongInfoTO sto = new SongInfoTO();

        String singer = null;
        String title = null;
        String exp = null;

        System.out.println("============ 노래 추가 =============");
        do{
            System.out.print("가수명 : ");
            singer = sc.nextLine();

            if(singer.isBlank()) {
                System.out.println("가수명을 입력하셔야 합니다.");
            }else{
                break;
            }
        }while(true);

        do{
            System.out.print("제목 : ");
            title = sc.nextLine();

            if(title.isBlank()) {
                System.out.println("제목을 입력하셔야 합니다.");
            }else{
                break;
            }
        }while(true);

        do{
            System.out.print("노래 설명 작성 여부 (Y / N) : ");
            String input = sc.nextLine().toUpperCase();

            if(input.equals("Y")){
                System.out.print("노래 설명 : " );
                exp = sc.nextLine();
                break;

            }else if(input.equals("N")){
                break;

            }else{
                System.out.println("올바른 입력이 아닙니다.");

            }
        }while(true);

        sto.setSinger(singer.strip());
        sto.setTitle(title.strip());
        sto.setExp( (exp != null && !exp.isBlank()) ? exp.strip() : null );

        System.out.println("최종 작성");
        System.out.println(sto);

        sto.setLink(crawl(sto.getSinger(), sto.getTitle()));

        return sto;
    }

    // 노래 정상 추가 여부 출력
    public void addSongOk(boolean flag){

        if(!flag){
            System.out.println("노래 추가 완료");
        }else{
            System.out.println("노래 추가 실패");
        }
    }

    // Youtube 최상단 검색 결과 링크 크롤링
    public String crawl(String singer, String title){

        singer = singer.replaceAll(" ", "").replaceAll("\t", "");
        title = title.replaceAll(" ", "").replaceAll("\t", "");

        String value = null;

        try {
            Document doc = null;
            Elements scripts = null;

            // Jsoup 라이브러리 이용 URL 요청에 대한 response를 받음
            // script를 통한 동적페이지 : user-agent 값 없을 시  미반환 > .userAgent(브라우저 정보) 사용
            doc = Jsoup.connect("https://www.youtube.com/results?search_query=" + singer + "+-+" + title + "+Auto-generated")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
                    .get();

            // script 태그 데이터들만 받음
            scripts = doc.getElementsByTag("script");

            System.out.println(scripts.size());
            // 주요 데이터는 34번째 script 태그 내부에 존재
            Element element = scripts.get(34);
            String data = element.html();

            // 변수 = JSON : "변수 = " 부분을 JSON 문자열 잘라 받기
            data = data.substring(data.indexOf("{"), data.length() - 1);

            // Gson 라이브러리 이용 JSON 데이터 파싱
            JsonObject obj = (JsonObject)JsonParser.parseString(data);

            JsonArray level1 = obj.getAsJsonObject("contents")
                    .getAsJsonObject("twoColumnSearchResultsRenderer")
                    .getAsJsonObject("primaryContents")
                    .getAsJsonObject("sectionListRenderer")
                    .getAsJsonArray("contents");

            JsonArray level2 = null;
            int firstIndex = 0;

            do{
                level2 = level1.get(firstIndex).getAsJsonObject()
                        .getAsJsonObject("itemSectionRenderer")
                        .getAsJsonArray("contents");

                for(JsonElement tempObj : level2){
                    if(tempObj.getAsJsonObject().has("videoRenderer")){
                        value = tempObj.getAsJsonObject()
                                .getAsJsonObject("videoRenderer")
                                .get("videoId").getAsString();
                        break;
                    }
                }

                firstIndex++;
            } while(value == null);

        } catch (MalformedJsonException e){
            System.out.println("[Error] : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Error] : " + e.getMessage());
        }

        return value;
    }
}
