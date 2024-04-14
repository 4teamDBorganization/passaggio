package com.passaggio.project.models.signup;

import com.passaggio.project.mapper.LoginMapper;
import org.apache.ibatis.session.SqlSession;
import static com.passaggio.project.common.Template.getSqlSession;

public class SignUpService {
    //회원가입
    public void registerUser(SignUpDTO signUpDTO) {
        try (SqlSession sqlSession = getSqlSession()) {
            LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
            mapper.insertUser(signUpDTO);
            sqlSession.commit();
        }
    }

    //아이디 중복 확인
    public boolean isIdAlreadyInUse(String id) {
        try (SqlSession sqlSession = getSqlSession()) {
            LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
            String existId = mapper.whatIsId(id);
            return existId != null;
        }
    }

    //닉네임 중복 확인
    public boolean isNickAlreadyInUse(String nick) {
        try (SqlSession sqlSession = getSqlSession()) {
            LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
            String existNick = mapper.whatIsNick(nick);
            return existNick != null;
        }
    }
}
