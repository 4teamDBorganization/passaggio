package com.passaggio.project.model.songinfo;

import com.passaggio.project.mapper.SongInfoMapper;
import org.apache.ibatis.session.SqlSession;

public class SongInfoDAO {

    private SongInfoMapper mapper;

    public int insertSongInfo(SqlSession sqlSession, SongInfoTO sto){
        mapper = sqlSession.getMapper(SongInfoMapper.class);

        int result = mapper.insertSongInfo(sto);

        return result;
    }
}
