package java_article_make.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java_article_make.dto.Member;
import java_article_make.util.Util;

public class MemberController extends Controller {
	static List<Member> members;
	private Scanner sc;
	private String cmd;
	private String actionMethodName;

	public MemberController(Scanner sc) {
		members = new ArrayList<>();
		this.sc = sc;
	}

	int lastMemberId = 3;

	public void doAction(String actionMethodName, String cmd) {
		this.cmd = cmd;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		case "logout":
			doLogout();
			break;
		default:
			System.out.println("존재하지 않는 명령어입니다.");
			break;
		}
	}

	public void doJoin() {
		if (isLogined() == false) {
			System.out.println("로그아웃 후 이용해 주세요.");
			return;
		}
		int id = lastMemberId + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = "";
		String loginId = null;
		String loginPw = null;
		String loginPwck = null;
		String name = null;

		while (true) {
			System.out.printf("아이디 : ");
			loginId = sc.nextLine();

			if (getMemberById(loginId) != null) {
				System.out.println("이미 존재하는 아이디 입니다.");
				continue;
			}
			break;
		}

		while (true) {
			System.out.printf("비밀번호 : ");
			loginPw = sc.nextLine();
			System.out.printf("비밀번호 확인 : ");
			loginPwck = sc.nextLine();

			if (loginPw.equals(loginPwck) == false) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				continue;
			}
			break;
		}

		System.out.printf("이름 : ");
		name = sc.nextLine();

		Member member = new Member(id, regDate, updateDate, loginId, loginPw, name);
		members.add(member);

		System.out.printf("%s님 회원가입 성공\n", name);

	}

	public void doLogin() {
		if (isLogined() == false) {
			System.out.println("로그아웃 후 이용해 주세요.");
			return;
		}
		String loginId = null;
		String loginPw = null;
		while (true) {
			System.out.printf("아이디 : ");
			loginId = sc.nextLine();
			if (getMemberById(loginId) == null) {
				System.out.println("없는 아이디입니다.");
				continue;
			}
			break;
		}

		Member member = getMemberById(loginId);
		while (true) {
			System.out.printf("비밀번호 : ");
			loginPw = sc.nextLine();

			if (member.loginPw.equals(loginPw) == false) {
				System.out.println("비밀번호가 틀렸습니다.");
				continue;
			} else {
				System.out.printf("%s님 로그인 성공\n", member.name);
				loginedMember = member;
			}
			break;
		}

	}

	public void doLogout() {
		if (isLogined() == true) {
			System.out.println("로그인 후 이용해 주세요.");
			return;
		} else {
			System.out.println("로그아웃");
			loginedMember = null;
		}

	}

	public void makeTestData() {
		members.add(new Member(1, Util.getNowDateStr(), "", "a", "a", "user1"));
		members.add(new Member(2, Util.getNowDateStr(), "", "b", "b", "user2"));
		members.add(new Member(3, Util.getNowDateStr(), "", "c", "c", "user3"));

	}

	public Member getMemberById(String loginId) {
		for (int i = 0; i < members.size(); i++) {
			Member member = members.get(i);

			if (member.logiId.equals(loginId)) {
				return members.get(i);
			}
		}
		return null;
	}

}