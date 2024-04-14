package com.passaggio.project.model.signup;

public class SignUpDTO implements java.io.Serializable{
    private int seq;            //회원번호
    private String id;          //회원아이디
    private String pwd;         //회원비밀번호
    private String nick;
    private char gender;        //성별

    public SignUpDTO() {
    }


    public SignUpDTO(int seq, String id, String pwd, String nick, char gender) {
        this.seq = seq;
        this.id = id;
        this.pwd = pwd;
        this.nick = nick;
        this.gender = gender;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
                ", 회원닉네임 : '" + nick + '\'' +
                ", 성별 : " + gender;
    }
}
