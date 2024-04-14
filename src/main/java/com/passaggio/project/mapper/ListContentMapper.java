package com.passaggio.project.mapper;

import com.passaggio.project.model.listcontent.ListContentTO;

import java.util.List;

public interface ListContentMapper {

    List<Integer> selectContentsByLseq(int lseq);

    int insertContent(ListContentTO lto);
}
