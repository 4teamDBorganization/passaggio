package com.passaggio.project.models.login;

import com.passaggio.project.mapper.LoginMapper;
import com.passaggio.project.models.signup.SignUpDTO;
import org.apache.ibatis.session.SqlSession;

import static com.passaggio.project.common.Template.getSqlSession;

public class LoginService {

    public SignUpDTO gologin(String id, String pwd) {
        try (SqlSession sqlSession = getSqlSession()) {
            LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
            SignUpDTO loginDTO = new SignUpDTO();
            loginDTO.setId(id);
            loginDTO.setPwd(pwd);
            return mapper.gologin(loginDTO);
        }
    }

}
