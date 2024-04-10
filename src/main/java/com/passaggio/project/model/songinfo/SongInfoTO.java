package com.passaggio.project.model.songinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@Alias("SongInfoTO")
public class SongInfoTO {

    private int seq;
    private String singer;
    private String title;
    private String link;
    private String exp;

}
