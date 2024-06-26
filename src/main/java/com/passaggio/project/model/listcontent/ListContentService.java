package com.passaggio.project.model.listcontent;

import com.passaggio.project.common.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ListContentService {
    private ListContentDAO dao;

    public ListContentService(){
        dao = new ListContentDAO();
    }

    public List<Integer> selectContentsByLseq(int lseq){
        SqlSession sqlSession = Template.getSqlSession();

        List<Integer> contents = dao.selectContentsByLseq(sqlSession, lseq);

        sqlSession.close();

        return contents;
    }

    public int isContentExists(ListContentTO lto){
        SqlSession sqlSession = Template.getSqlSession();

        int result = dao.isContentExists(sqlSession, lto);

        sqlSession.close();

        return result;
    }

    public int insertContent(ListContentTO lto){
        SqlSession sqlSession = Template.getSqlSession();

        int result = dao.insertContent(sqlSession, lto);

        if(result == 1){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        return result;
    }

    public int deleteContent(ListContentTO lto){
        SqlSession sqlSession = Template.getSqlSession();

        int result = dao.deleteContent(sqlSession, lto);

        if(result == 1){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        return result;
    }

    public int deleteContents(int lseq, int count){
        SqlSession sqlSession = Template.getSqlSession();

        int result = dao.deleteContents(sqlSession, lseq);

        if(result == count){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        return result;
    }
}
