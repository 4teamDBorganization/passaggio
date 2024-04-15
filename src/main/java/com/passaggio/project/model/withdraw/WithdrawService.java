package com.passaggio.project.model.withdraw;

import com.passaggio.project.mapper.LoginMapper;
import org.apache.ibatis.session.SqlSession;

import static com.passaggio.project.common.Template.getSqlSession;

public class WithdrawService {
    public static boolean deleteUser(String id) {
        try (SqlSession sqlSession = getSqlSession()) {
            LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
            int result = mapper.deleteUser(id);
            sqlSession.commit(); // 변경사항 커밋
            return result > 0; // 회원 삭제 성공 여부 반환
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 예외 발생 시 삭제 실패로 간주
        }
    }
}
