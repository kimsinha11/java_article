package java_article_make.controller;

import java.util.Scanner;

import java_article_make.dto.Article;
import java_article_make.dto.Member;
import java_article_make.service.ArticleService;
import java_article_make.service.MemberService;
import java_article_make.util.Util;

public class ArticleController extends Controller{

	private Scanner sc;
	private String cmd;
	public String actionMethodName;
	private ArticleService articleService;
	private MemberService memberServcie;
	
	public ArticleController(Scanner sc) {
		articleService = new ArticleService();
		memberServcie = new MemberService();
		this.sc = sc;
	}
	
	int lastArticleId = 3;
	
	public void doAction(String actionMethodName, String cmd) {
		this.cmd = cmd;
		this.actionMethodName = actionMethodName;
		
		switch(actionMethodName) {
		case "write":
			doWrite();
			break;
		case "list":
			showList();
			break;
		case "detail":
			showDetail();
			break;
		case "delete":
			doDelete();
			break;
		case "modify":
			doModify();
			break;
		default:
			System.out.println("존재하지 않는 명령어입니다.");
			break;
		}
	}

	public void doWrite() {
		if (isLogined() == true) {
			System.out.println("로그인 후 이용해 주세요.");
			return;
		}
		int id = lastArticleId + 1;
		System.out.printf("제목 : ");
		String title = sc.nextLine();
		System.out.printf("내용 : ");
		String body = sc.nextLine();
		String regDate = Util.getNowDateStr();
		String updateDate = "";

		Article article = new Article(id, loginedMember.id, regDate, updateDate, title, body);
		articleService.add(article);

		System.out.printf("%d번 글이 작성되었습니다.\n", id);
		lastArticleId++;
		
	}

	public void showList() {
		if (articleService.size() == 0) {
			System.out.println("게시물이 없습니다.");
		} else {
			System.out.printf("번호 / 작성자 / 제목 / 작성날짜 / 조회수\n");

			for (int i = articleService.size() - 1; i >= 0; i--) {
				Article article = articleService.get(i);
				String wrtier = null;
				
				for(int j = 0; j<memberServcie.size(); j++) {
					Member member = memberServcie.get(j);
					if(article.memberId==member.id)
					wrtier = member.name;
				}

				System.out.printf("%d / %s / %s / %s / %d \n", article.id, wrtier, article.title,
						article.regDate, article.hit);
			}
		}
	}

	public void showDetail() {

		String detail[] = cmd.split(" ");
		int id = Integer.parseInt(detail[2]);
		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 없습니다.\n", id);
			return;
		} else {
			String wrtier = null;
			
			for(int j = 0; j<memberServcie.size(); j++) {
				Member member = memberServcie.get(j);
				if(foundArticle.memberId==member.id)
				wrtier = member.name;
			}
			foundArticle.hitup();
			System.out.printf("번호 : %d\n작성자 : %s\n제목 : %s\n내용 : %s\n작성날짜 : %s\n수정날짜 : %s\n조회수 : %d\n",
					foundArticle.id, wrtier, foundArticle.title, foundArticle.body,
					foundArticle.regDate, foundArticle.updateDate, foundArticle.hit);
		}
		
	}

	public void doDelete() {
		if (isLogined() == true) {
			System.out.println("로그인 후 이용해 주세요.");
			return;
		}
		String delete[] = cmd.split(" ");
		int id = Integer.parseInt(delete[2]);
		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 없습니다.\n", id);
			return;
		} else if (loginedMember.id == foundArticle.memberId) {
			articleService.remove(foundArticle);
			System.out.printf("%d번 글이 삭제되었습니다.\n", id);
		} else {
			System.out.println("권한이 없습니다.");
			return;
		}
		
	}

	public void doModify() {
		if (isLogined() == true) {
			System.out.println("로그인 후 이용해 주세요.");
			return;
		}
		String modify[] = cmd.split(" ");
		int id = Integer.parseInt(modify[2]);
		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 없습니다.\n", id);
			return;
		} else if (loginedMember.id == foundArticle.memberId) {
			System.out.printf("제목 : ");
			String title = sc.nextLine();
			System.out.printf("내용 : ");
			String body = sc.nextLine();
			String updateDate = Util.getNowDateStr();

			foundArticle.title = title;
			foundArticle.body = body;
			foundArticle.updateDate = updateDate;

			System.out.printf("%d번 글이 수정되었습니다.\n", id);
		} else {
			System.out.println("권한이 없습니다.");
			return;
		}
		
	}
	public Article getArticleById(int id) {
		for (int i = 0; i < articleService.size(); i++) {
			Article article = articleService.get(i);

			if (article.id == id) {
				return article;
			}
		}
		return null;
	}
	
	public void makeTestData() {
		articleService.add(new Article(1, 1, Util.getNowDateStr(), "", "제목1", "내용1", 11));
		articleService.add(new Article(2, 2, Util.getNowDateStr(), "", "제목2", "내용2", 22));
		articleService.add(new Article(3, 3, Util.getNowDateStr(), "", "제목3", "내용3", 33));

	}
	
}