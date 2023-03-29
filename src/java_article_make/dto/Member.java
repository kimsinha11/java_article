package java_article_make.dto;

public class Member extends Dto {

	public String logiId;
	public String loginPw;
	public String name;

	public Member(int id, String regDate, String updateDate, String loginId, String loginPw, String name) {
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.logiId = loginId;
		this.loginPw = loginPw;
		this.name = name;
	}
}
