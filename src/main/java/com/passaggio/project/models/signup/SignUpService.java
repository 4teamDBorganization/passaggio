package com.passaggio.project.models.signup;

import com.passaggio.project.mapper.LoginMapper;
import com.passaggio.project.models.signup.SignUpDTO;
import org.apache.ibatis.session.SqlSession;

import static com.passaggio.project.common.Template.getSqlSession;

public class SignUpService {
    private LoginMapper mapper;

    public boolean userSignUp(SignUpDTO signUpDTO){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(LoginMapper.class);
        int result = mapper.userCheck(signUpDTO);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0? true : false;
    }
}
