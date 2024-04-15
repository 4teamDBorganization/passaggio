## 🎤passaggio
# 🎵개인 플레이리스트 만들기!
<p align="center"><img src="https://github.com/4teamDBorganization/passaggio/assets/105586878/a844b432-1010-49e5-93e2-a7c8a8f4bcaa" height=800 width=800></p>

<br><br>

## 🎤프로젝트 소개
- 개인 플레이리스트 파일을 만들고, 사용자가 직접 노래를 직접 설정하여 만드는 플레이리스트
- 로그인을 통한 마이 플레이리스트 관리 가능
- 마이페이지에서 새로운 노래 등록 및 조회 가능
- 유튜브 링크를 통해서 노래 감상 가능
- 전체 플레이리스트 페이지에서 다른 사용자와 서로의 플레이리스트 공유 가능



<br><br>


## 😊팀원 구성

<div align="center">

| **도영익** | **배민서** | **안효준** | **이수빈** |
| :------: |  :------: | :------: | :------: |
|[<img src="https://github.com/4teamDBorganization/passaggio/assets/105586878/f1af7145-4133-4ac3-a2b5-9dcf5f27467a" height=150 width=150> <br/> @do0ik](https://github.com/do0ik)|[<img src="https://github.com/4teamDBorganization/passaggio/assets/105586878/e77503db-a0d0-454b-846f-f48b74992bac" height=150 width=150> <br/> @Baeminseo](https://github.com/Baeminseo) |[<img src="https://github.com/4teamDBorganization/passaggio/assets/105586878/cd06b1de-bc1a-4d55-8ef9-a428b9f59b16" width="150" height="150"/> <br/> @hyojunahn111](https://github.com/hyojunahn111) | [<img src="https://github.com/4teamDBorganization/passaggio/assets/105586878/10bb1a42-1ab8-4a61-95a3-ba401b5845df" height=150 width=150><br/> @joy:)](https://github.com/sb-77) |
</div>

### 🧑‍💻역할 분담

#### 도영익
- 플레이리스트, 노래부분

    
#### 배민서
- 회원가입, 로그인


#### 안효준
- 회원가입, 로그인

#### 이수빈 
- 플레이리스트, 노래부분
    
<br>



<br><br>

## 🗓️파사지오 프로젝트 타임라인

<br><br> 

<p align="center"><img src="https://github.com/4teamDBorganization/passaggio/assets/105586878/c6e4e3fb-e7f5-40e1-8e4a-1b565b41a0bc" height=650 width=1000></p>

<br><br> 

## 🗓️개발 과정


<br><br> 

<p align="center"><img src="https://github.com/4teamDBorganization/passaggio/assets/105586878/3dc9c4bd-0109-4e7a-a948-5ef7db6a8f1e" height=540 width=540></p>

- 기획하기 : NOTION, DISCORD
- 개념적 설계 ERD : DIAGRAMS DRAW_IO
- 논리적 설계 스키마 : ERDCLOUD
- 코드 작성 : INTELLIJ

- 모든 과정에서 회의를 통해 다음 단계로 넘어가도록 했습니다.
- 회의 과정에서 수정된 부분을 노션에 기록하고, 참고하며 개발했습니다.

<br><br>
## 💻개발환경
<br><br> 

<p align="center"><img src="https://github.com/4teamDBorganization/passaggio/assets/105586878/4ae64f95-9d4d-42ad-b575-d48b2cc50f7f" height=400 width=600></p>


<br><br> 
- Back-end : IntelliJ IDEA, Java 17, mySQL, MyBatis, ERD Croud, Diagrams Draw_IO
- 버전 및 이슈관리 : Github, Github Issues, Github Project
<div align=left><h4>협업 툴</h4></div>
<div align=left><img src="https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=Discord&logoColor=white"/><a href="https://www.notion.so/e9077bdb30f14515bc1c52f838aa2360?pvs=4"><img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white"/></a><img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white"/></div>

<br>

### 🌳브랜치 전략
- main 브랜치와 feature 보조 브랜치를 운용했습니다.
- **main** 브랜치는 배포 단계에서만 사용하는 브랜치입니다.
- **feature** 브랜치는 각 구현 단위로 구분하여 사용했습니다.
- **feature** 브랜치를 자기 브랜치 커밋용 및 테스트용으로 이용했습니다.
      

<br><br>

## 🧱프로젝트 구조
...
📦src
 ┗ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂passaggio
 ┃ ┃ ┃ ┃ ┗ 📂project
 ┃ ┃ ┃ ┃ ┃ ┣ 📂application
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Application.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Template.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Controller.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LostController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SignUpController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WithdrawController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂delay
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Delay.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂mapper
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ListContentMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PlaylistMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SongInfoMapper.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂listcontent
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ListContentDAO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ListContentService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ListContentTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂login
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoginService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂playlist
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PlaylistDAO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PlaylistService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PlaylistTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂signup
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SignUpDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SignUpService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂songinfo
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SongInfoDAO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SongInfoService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SongInfoTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂withdraw
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WithdrawService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂myPage
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MypageService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜NoneUserpage.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂view
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂login
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Login.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂lostaccount
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LostAccount.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LostAccountService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂signup
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SignUp.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂withdraw
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Withdraw.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PlaylistViews.java
 ┃ ┗ 📂resources
 ┃ ┃ ┣ 📂com
 ┃ ┃ ┃ ┗ 📂passaggio
 ┃ ┃ ┃ ┃ ┗ 📂project
 ┃ ┃ ┃ ┃ ┃ ┗ 📂mapper
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ListContentMapper.xml
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginMapper.xml
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PlaylistMapper.xml
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SongInfoMapper.xml
 ┃ ┃ ┗ 📂config
 ┃ ┃ ┃ ┗ 📜mybatis-config.xml
...



<br><br> 

## 📌개념설계 ERD
<p align="center"><img src="https://github.com/4teamDBorganization/passaggio/assets/105586878/1c4069fa-834c-42e3-a2fe-b23f266bc741" height=1200 width=850></p>
<p align="center"><img src="https://github.com/4teamDBorganization/passaggio/assets/105586878/6812f025-8139-4de8-be39-901c54044b14" height=550 width=1000></p>



<br><br> 

## 7. 프로젝트 후기

### 😌도영익

git을 연동해서 프로젝트를 계획한여 협업을 이번 수업에서 처음 경험해봤습니다. 그만큼 미숙하고 낯설어 처음 조가 짜여지고 깃을 연동하려 했을 때 연동도 제대로 되지 않아 따라가기 너무 벅찼는데 시간이 지나면서 조금씩 git에 적응하고 팀원들하고도 어색함이 사그라지면서 좋은 프로젝트를 만들어간것 같습니다. 특히 git에서 각자의 맡은 부분을 하고 머지를 할때 처음 해보는 작업이고 에러도 나서 에러가 왜 생겼는지 이해하기도 어려웠고 해결도 오래걸렸습니다. 하지만 처음으로 git을 통한 협업 프로젝트를 해본 경험으로 앞으로 할 팀프로젝트에서 큰 도움이 될거라 확신합니다.
-수정해서 사용하세용!

<br>

### 🤗배민서

이번 프로젝트에서 깃허브를 통한 협업 경험은 제게 성장의 발판이 되었습니다. 이전에는 깃허브를 코드 공유 용도로만 활용하여 제대로 활용해본 적이 없었습니다. 그러나 이번 프로젝트를 통해 이슈 트래킹, 풀 리퀘스트, 머지 등을 배우며 협업 툴의 중요성과 활용 방법에 대해 깊이 이해할 수 있었습니다. 수 많은 오류와 어려움을 겪으며 힘든 순간도 많았지만 오히려 오류 덕분에 깃허브를 이용한 협업에 대해 더욱 깊이 배울 수 있었습니다.
더불어 협업 툴을 활용함으로써 이번 프로젝트가 더욱 완성도 있게 만들어졌다는 느낌을 받았습니다. 팀 분위기도 좋았고 서로 협력하며 프로젝트를 성공적으로 마무리한 것 같아서 뿌듯합니다. 이번 프로젝트를 통해 깃허브를 이용한 협업에 대한 기초를 다졌으며, 앞으로의 프로젝트에서도 보다 효율적으로 협업할 수 있을 것이라고 생각합니다.
-수정해서 사용하세용!

<br>

### 🙂안효준

백엔드과정을 시작한지 얼마안된 상황에서 팀프로젝트를 시작하게 되어서 조금 힘들었지만, 팀원분들을 잘 만나서 잘 마무리 할 수 있었습니다. 팀 프로젝트 초기에 기획을 하면서 프로젝트의 방향성을 제대로 잡을 수 있었고, 초기 설정을 진행하며 쳬계적인 설계의 중요성을 느낄 수 있었습니다. 앞으로의 프로젝트들도 체계적이고 효율적으로 진행할 수 있는 방법을 많이 배웠던 프로젝트 였습니다. 각자 기능역할에 대해서 공부하며 코드를 짜보는 시간을 갖고, 그 다음에 팀원들끼리 서로 부족한 부분을 채우면서 프로젝트를 진행하여 좋은 팀 협업을 경험할 수 있었습니다. 팀원들이 서로서로 도와서 문제를 해결하려고 해서 예상보다 더 빠르게 프로젝트를 마무리할 수 있었습니다. 하지만 빠르게 작업을 진행하느라 함께 해결한 이슈가 어떤 이슈이며 어떻게 해결했는지에 대해 자세히 정리해볼 시간이 없어서 아쉬웠습니다. 이번의 경험을 통해 다음 프로젝트에서도 더욱 발전된 모습을 보일 수 있었으면 좋겠습니다. 늦은 시간까지도 항상 열심히 참여해준 팀원들에게 감사합니다. 다음에도 또 만나요:)
-수정해서 사용하세용!

<br>

### 😆이수빈

협업 툴을 사용하는 것은 저번 프로젝트에 비해서 많이 나아져서 저번보다는 속도가 더 빠르게 진행 될 수 있었던 것 같습니다. 그런데 자바에 이어서 DB에 MyBatis까지 배우며, 이해가 안가는 부분도 많았고 프로젝트를 하면서 이해가 되어 가는 순간도 많았습니다.
이번 프로젝트도 좋은 팀원 분들을 만나서 좋은 기록을 남기며 프로젝트를 잘 진행할 수 있었던 것 같습니다. 이번 프로젝트를 통해서 저의 한계를 많이 느끼기도 했지만, 한편으로는 앞으로 어떻게 나아가야할지 방향성을 생각해볼 수 있던 프로젝트였습니다. 
프로젝트를 하면서 막히는 부분들을 팀원분들이 열정적으로 도와주셔서 도움을 많이 받았던 프로젝트였습니다. 다들 늦은 시간에도 프로젝트를 위해서 열심히 해주셔서 정말 감사했습니다. 다음에도 또 같은 팀으로 만났으면 좋겠네요!!><

<br>




