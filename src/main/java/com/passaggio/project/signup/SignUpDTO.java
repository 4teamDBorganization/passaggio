package com.passaggio.project.signup;

public class SignUpDTO {
    private int seq;            //회원번호
    private String id;          //회원아이디
    private String pwd;         //회원비밀번호
    private char gender;        //성별

    public SignUpDTO() {
    }

    public SignUpDTO(int seq, String id, String pwd, char gender) {
        this.seq = seq;
        this.id = id;
        this.pwd = pwd;
        this.gender = gender;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return  "당신의 회원정보 = " +
                "회원번호 : " + seq +
                ", 회원아이디 : '" + id + '\'' +
                ", 회원비밀번호 : '" + pwd + '\'' +
                ", 성별 : " + gender;
    }
}
