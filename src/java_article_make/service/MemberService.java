package java_article_make.service;

import java_article_make.container.Container;
import java_article_make.dao.MemberDao;
import java_article_make.dto.Member;

public class MemberService {
	private MemberDao memberDao;

	public MemberService() {
		this.memberDao = Container.memberDao;
	}

	public void add(Member member) {
		memberDao.add(member);
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return memberDao.size();
	}

	public Member get(int i) {
		// TODO Auto-generated method stub
		return memberDao.get(i);
	}
}
