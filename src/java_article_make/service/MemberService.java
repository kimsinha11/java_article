package java_article_make.service;

import java.util.List;

import java_article_make.container.Container;
import java_article_make.dao.MemberDao;
import java_article_make.dto.Member;

public class MemberService {
	private MemberDao memberDao;

	public MemberService() {
		this.memberDao = Container.memberDao;
	}

	public int setNewId() {

		int id = memberDao.setNewId();
		return id;
	}

	public void add(Member member) {

		memberDao.add(member);
	}

	public Member getMemberByLoginId(String loginId) {

		return memberDao.getMemberByLoginId(loginId);
	}

	public boolean isJoinableLoginId(String loginId) {

		return memberDao.isJoinableLoginId(loginId);
	}



	public List<Member> getMembers() {

		return memberDao.getMembers();
	}

	public String getMemberNameById(int memberId) {
		// TODO Auto-generated method stub
		return null;
	}
}
