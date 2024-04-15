package com.passaggio.project.model.playlist;

import com.passaggio.project.common.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PlaylistService {

    private PlaylistDAO dao;

    public PlaylistService(){
        dao = new PlaylistDAO();
    }

    public List<PlaylistTO> selectAllList(){
        SqlSession sqlSession = Template.getSqlSession();

        List<PlaylistTO> plList = dao.selectAllList(sqlSession);

        sqlSession.close();

        return plList;
    }

    public List<PlaylistTO> selectUserPlList(int mseq){
        SqlSession sqlSession = Template.getSqlSession();

        List<PlaylistTO> plList = dao.selectUserPlList(sqlSession, mseq);

        sqlSession.close();

        return plList;
    }

    public int insertPlaylist(PlaylistTO pto){
        SqlSession sqlSession = Template.getSqlSession();

        int result = dao.insertPlaylist(sqlSession, pto);

        if(result == 1){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public int modifyPlaylist(PlaylistTO pto){
        SqlSession sqlSession = Template.getSqlSession();

        int result = dao.modifyPlaylist(sqlSession, pto);

        if(result == 1){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public int deletePlaylist(int lseq){
        SqlSession sqlSession = Template.getSqlSession();

        int result = dao.deletePlaylist(sqlSession, lseq);

        if(result == 1){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }
}
