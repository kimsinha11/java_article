package java_article_make.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java_article_make.dto.Member;
import java_article_make.util.Util;

public class MemberController extends Controller{
	private List<Member> members;
	private Scanner sc;
	private String actionMethodName;
	private String command;

	public MemberController(Scanner sc) {
		members = new ArrayList<>();
		this.sc = sc;
	}
	
	public void doAction(String actionMethodName, String command) {
		this.actionMethodName = actionMethodName;
		this.command = command;
		
		switch(actionMethodName) {
		case "join":
			doJoin();
			break;
		case "list":
			showList();
			break;
		default:
			System.out.println("다시 입력해주세요.");
			break;
		}
	}
	
	int lastmemberid = 3;
	public void showList() {
		if (members.size() == 0) {
			System.out.println("게시글이 없습니다");
			return;
		} else {
			System.out.printf(" 번호| 이름 | 제목 |        가입 날짜         |\n");
			for (int i = members.size() - 1; i >= 0; i--) {
				Member member = members.get(i);

				System.out.printf(" %d | %s |  %s  |  %s  |\n", member.id, member.name, member.loginId, member.regDate);
			}
		}
	}

	public void doJoin() {
		int id = lastmemberid + 1;
		String regDate = Util.getNowDateStr();

		String loginId = null;
		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();

			if (getMemberById(loginId) == false) {
				System.out.printf("%s는(은) 이미 사용 중인 아이디 입니다.\n", loginId);
				continue;
			}
			break;

		}

		String loginPw = null;
		String loginPwCf = null;
		while (true) {
			System.out.printf("로그인 비밀번호 : ");
			loginPw = sc.nextLine();
			System.out.printf("로그인 비밀번호 확인 : ");
			loginPwCf = sc.nextLine();

			if (loginPw.equals(loginPwCf) == false) {
				System.out.println("비밀번호를 다시 입력해주세요.");
				continue;
			}
			break;
		}

		System.out.printf("이름 : ");
		String name = sc.nextLine();

		Member member = new Member(id, name, loginId, loginPw, regDate);
		members.add(member);

		System.out.printf("%s님 회원가입 되었습니다.\n", name);
	}

	private boolean getMemberById(String loginId) {
		for (Member member : members) {
			if (member.loginId.equals(loginId)) {
				return false;
			}
		}
		return true;
	}
	public void maketestdata() {
		System.out.println("==회원 테스트 데이터 생성==");
		members.add(new Member(1, "동연", "a", "aa", Util.getNowDateStr()));
		members.add(new Member(2, "신하", "b", "bb", Util.getNowDateStr()));
		members.add(new Member(3, "용준", "c", "cc", Util.getNowDateStr()));

	}

}