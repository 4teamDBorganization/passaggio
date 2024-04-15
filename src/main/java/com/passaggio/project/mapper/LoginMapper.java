package com.passaggio.project.mapper;

import com.passaggio.project.model.signup.SignUpDTO;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
    void insertUser(SignUpDTO signUpDTO);

    String whatIsId(String id);
    String whatIsNick(String nick);
    String whatIsMyNick(String nick);
    String whatIsPwd(@Param("id") String id, @Param("pwd")String pwd);
    SignUpDTO FindAccountId(@Param("seq")int seq, @Param("nick")String nick, @Param("gender")String gender);
    String findUserIdByInfo(@Param("seq") int seq, @Param("nick") String nick, @Param("gender") String gender);
    SignUpDTO FindAccountPwd(@Param("seq")int seq, @Param("id")String id);
    String findUserPwdByInfo(@Param("seq") int seq, @Param("id") String id);
    String yourSeq(String id);

    SignUpDTO gologin(SignUpDTO signUpDTO);

    int deleteUser(String id);
}
