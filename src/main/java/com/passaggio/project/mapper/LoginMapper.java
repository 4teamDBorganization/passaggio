package com.passaggio.project.mapper;

import com.passaggio.project.models.signup.SignUpDTO;

public interface LoginMapper {

    int userCheck(SignUpDTO signUpDTO);
}
