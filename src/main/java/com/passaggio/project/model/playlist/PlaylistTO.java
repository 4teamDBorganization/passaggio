package com.passaggio.project.model.playlist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
public class PlaylistTO {

    private int seq;
    private int mseq;
    private String lname;
    private String exp;


}
