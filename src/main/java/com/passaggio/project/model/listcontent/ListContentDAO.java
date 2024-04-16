package com.passaggio.project.model.listcontent;

import com.passaggio.project.mapper.ListContentMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ListContentDAO {

    private ListContentMapper mapper;

    // 리스트 내부 노래 정보 조회
    public List<Integer> selectContentsByLseq(SqlSession sqlSession, int lseq){
        mapper = sqlSession.getMapper(ListContentMapper.class);

        return mapper.selectContentsByLseq(lseq);
    }

    // 노래 있는지 확인
    public int isContentExists(SqlSession sqlSession, int sseq){
        mapper = sqlSession.getMapper(ListContentMapper.class);

        return mapper.isContentExists(sseq);
    }


    // 노래 추가
    public int insertContent(SqlSession sqlSession, ListContentTO lto){
        mapper = sqlSession.getMapper(ListContentMapper.class);

        return mapper.insertContent(lto);
    }

    // 특정 노래 삭제
    public int deleteContent(SqlSession sqlSession, ListContentTO lto){
        mapper = sqlSession.getMapper(ListContentMapper.class);

        return mapper.deleteContent(lto);
    }

    // 리스트 삭제
    public int deleteContents(SqlSession sqlSession, int lseq){
        mapper = sqlSession.getMapper(ListContentMapper.class);

        return mapper.deleteContents(lseq);
    }
}
