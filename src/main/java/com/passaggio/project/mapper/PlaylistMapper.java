package com.passaggio.project.mapper;

import com.passaggio.project.model.playlist.PlaylistTO;
import com.passaggio.project.model.songInfo.SongInfoTO;

public interface PlaylistMapper {


    // 플레이리스트 생성 int mseq, String lname
    int createPlaylist(PlaylistTO pto);

    // 플레이리스트 삭제
    int deletePlaylist(int seq);

    // 플레이리스트 노래 추가
    int insertSongInfo(SongInfoTO sto);

    // 플레이리스트 노래 삭제
    int deleteSongInfo(int lseq, int sseq);


}
