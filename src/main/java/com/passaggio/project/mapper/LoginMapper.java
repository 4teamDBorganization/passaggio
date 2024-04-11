package com.passaggio.project.mapper;

import com.passaggio.project.models.signup.SignUpDTO;

public interface LoginMapper {
    void insertUser(SignUpDTO signUpDTO);

    String whatIsId(String id);

    SignUpDTO gologin(SignUpDTO signUpDTO);
}
