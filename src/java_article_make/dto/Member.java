package java_article_make.dto;

public class Member extends Dto {
	public int id;
	public String name;
	public String loginId;
	public String loginPw;

	public Member(int id, String name, String loginId, String loginPw, String regDate) {
		this.id = id;
		this.name = name;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.regDate = regDate;
	}

}