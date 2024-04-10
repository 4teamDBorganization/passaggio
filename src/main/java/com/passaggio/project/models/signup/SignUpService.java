package com.passaggio.project.models.signup;

import com.passaggio.project.mapper.LoginMapper;
import org.apache.ibatis.session.SqlSession;
import static com.passaggio.project.common.Template.getSqlSession;

public class SignUpService {
    public void registerUser(SignUpDTO signUpDTO) {
        try (SqlSession sqlSession = getSqlSession()) {
            LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
            mapper.insertUser(signUpDTO);
            sqlSession.commit();
        }
    }
}
