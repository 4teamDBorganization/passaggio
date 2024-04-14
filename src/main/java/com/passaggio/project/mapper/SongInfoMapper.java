package com.passaggio.project.mapper;

import com.passaggio.project.model.songinfo.SongInfoTO;

import java.util.List;

public interface SongInfoMapper {

    SongInfoTO selectSongByInfo(SongInfoTO sto);

    List<SongInfoTO> selectSongsInContents(List<Integer> contents);

    List<SongInfoTO> selectSongsInContents2(int lseq);

    int insertSongInfo(SongInfoTO sto);
}
