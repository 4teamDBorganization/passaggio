package com.passaggio.project.view.lostaccount;

import com.passaggio.project.mapper.LoginMapper;
import com.passaggio.project.model.signup.SignUpDTO;
import org.apache.ibatis.session.SqlSession;

import static com.passaggio.project.common.Template.getSqlSession;

public class LostAccountService {
    public static boolean findmyid(int seq, String nick, String gender) {
        try (SqlSession sqlSession = getSqlSession()) {
            LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
            SignUpDTO findId = mapper.FindAccountId(seq, nick, gender);
            return findId != null; //false 반환
        }
    }

    public String tellMyId(int seq, String nick, String gender) {
        try (SqlSession sqlSession = getSqlSession()) {
            LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
            return mapper.findUserIdByInfo(seq, nick, gender);
        }
    }

    public static boolean findmypwd(int seq, String id) {
        try (SqlSession sqlSession = getSqlSession()) {
            LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
            SignUpDTO findPwd = mapper.FindAccountPwd(seq, id);
            return findPwd != null; //false 반환
        }
    }

    public String tellMyPwd(int seq, String id) {
        try (SqlSession sqlSession = getSqlSession()) {
            LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
            return mapper.findUserPwdByInfo(seq, id);
        }
    }
}
