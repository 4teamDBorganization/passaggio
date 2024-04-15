package com.passaggio.project.mapper;

import com.passaggio.project.model.listcontent.ListContentTO;

import java.util.List;

public interface ListContentMapper {

    // 리스트 내부 노래 정보 조회
    List<Integer> selectContentsByLseq(int lseq);

    // 노래 추가
    int insertContent(ListContentTO lto);

    // 특정 노래 삭제
    int deleteContent(ListContentTO lto);

    // 리스트 삭제
    int deleteContents(int lseq);
}
