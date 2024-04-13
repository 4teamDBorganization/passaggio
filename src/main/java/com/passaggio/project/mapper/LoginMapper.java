package com.passaggio.project.mapper;

import com.passaggio.project.models.signup.SignUpDTO;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
    void insertUser(SignUpDTO signUpDTO);

    String whatIsId(String id);
    String whatIsNick(String nick);
    String whatIsMyNick(String nick);
    SignUpDTO FindAccountId(@Param("seq")int seq, @Param("nick")String nick, @Param("gender")String gender);

    SignUpDTO gologin(SignUpDTO signUpDTO);

}
