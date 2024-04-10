package com.passaggio.project.model.playlist;

import com.passaggio.project.mapper.PlaylistMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PlaylistDAO {

    private PlaylistMapper mapper;

    public List<PlaylistTO> selectAllList(SqlSession sqlSession){
        mapper = sqlSession.getMapper(PlaylistMapper.class);

        return mapper.selectAllList();
    }

    public List<PlaylistTO> selectUserPlList(SqlSession sqlSession, int mseq){
        mapper = sqlSession.getMapper(PlaylistMapper.class);

        return mapper.selectUserPlList(mseq);
    }

    public int insertPlaylist(SqlSession sqlSession, PlaylistTO pto){
        mapper = sqlSession.getMapper(PlaylistMapper.class);

        return mapper.insertPlaylist(pto);
    }
}
