package com.passaggio.project.mapper;

import com.passaggio.project.model.playlist.PlaylistTO;

import java.util.List;

public interface PlaylistMapper {

    // 전체 플레이리스트 조회
    List<PlaylistTO> selectAllList();

    // 로그인 중인 회원 플레이리스트 조회
    List<PlaylistTO> selectUserPlList(int mseq);

    // 플레이리스트 생성
    int insertPlaylist(PlaylistTO pto);

    // 플레이리스트 수정
    int modifyPlaylist(PlaylistTO pto);

    // 플레이리스트 삭제
    int deletePlaylist(int seq);


}
