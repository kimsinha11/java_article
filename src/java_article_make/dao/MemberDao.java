package java_article_make.dao;

import java.util.ArrayList;
import java.util.List;

import java_article_make.dto.Member;

public class MemberDao {
	public static List<Member> members;
	
	public MemberDao() {
		members = new ArrayList<>();
	}

	public void add(Member member) {
		members.add(member);
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return members.size();
	}

	public Member get(int i) {
		// TODO Auto-generated method stub
		return members.get(i);
	}
}
