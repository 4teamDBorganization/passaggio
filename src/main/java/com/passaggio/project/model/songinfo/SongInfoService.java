package com.passaggio.project.model.songinfo;

import com.passaggio.project.common.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SongInfoService {

    private SongInfoDAO dao;

    public SongInfoService() {
        dao = new SongInfoDAO();
    }

    public SongInfoTO selectSongByInfo(SongInfoTO sto){
        SqlSession sqlSession = Template.getSqlSession();

        SongInfoTO result = dao.selectSongByInfo(sqlSession, sto);

        sqlSession.close();

        return result;
    }

    public List<SongInfoTO> selectSongsInContents(List<Integer> contents){
        SqlSession sqlSession = Template.getSqlSession();

        List<SongInfoTO> infos = dao.selectSongsInContents(sqlSession, contents);

        sqlSession.close();

        return infos;
    }

    public int insertSongInfo(SongInfoTO sto){
        SqlSession sqlSession = Template.getSqlSession();

        int result = dao.insertSongInfo(sqlSession, sto);

        if(result == 1){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }
}