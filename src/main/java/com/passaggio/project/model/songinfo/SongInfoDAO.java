package com.passaggio.project.model.songinfo;

import com.passaggio.project.mapper.SongInfoMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SongInfoDAO {

    private SongInfoMapper mapper;

    public SongInfoTO selectSongByInfo(SqlSession sqlSession, SongInfoTO sto){
        mapper = sqlSession.getMapper(SongInfoMapper.class);

        return mapper.selectSongByInfo(sto);
    }

    public List<SongInfoTO> selectSongsInContents(SqlSession sqlSession, List<Integer> contents){
        mapper = sqlSession.getMapper(SongInfoMapper.class);

        return mapper.selectSongsInContents(contents);
    }

    public int insertSongInfo(SqlSession sqlSession, SongInfoTO sto){
        mapper = sqlSession.getMapper(SongInfoMapper.class);

        return mapper.insertSongInfo(sto);
    }
}
