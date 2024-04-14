package com.passaggio.project.model.listcontent;

import com.passaggio.project.mapper.ListContentMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ListContentDAO {

    private ListContentMapper mapper;

    public List<Integer> selectContentsByLseq(SqlSession sqlSession, int lseq){
        mapper = sqlSession.getMapper(ListContentMapper.class);

        return mapper.selectContentsByLseq(lseq);
    }

    public int insertContent(SqlSession sqlSession, ListContentTO lto){
        mapper = sqlSession.getMapper(ListContentMapper.class);

        return mapper.insertContent(lto);
    }
}
