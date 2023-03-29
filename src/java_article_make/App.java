package java_article_make;

import java.util.Scanner;

import java_article_make.controller.ArticleController;
import java_article_make.controller.Controller;
import java_article_make.controller.MemberController;

public class App {

	public void start() {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		ArticleController articleController = new ArticleController(sc);
		MemberController memberController = new MemberController(sc);

		Controller controller = null;
		articleController.makeTestData();
		memberController.makeTestData();

		while (true) {
			System.out.printf("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}
			String cmdDiv[] = cmd.split(" ");

			String controllerName = cmdDiv[0];

			if (cmdDiv.length == 1) {
				System.out.println("명령어를 확인해주세요.");
				continue;
			}

			String actionMethodName = cmdDiv[1];

			if (controllerName.equals("article")) {
				controller = articleController;
			} else if (controllerName.equals("member")) {
				controller = memberController;
			}

			else {
				System.out.println("명령어가 없습니다.");
				continue;
			}
			
			controller.doAction(actionMethodName, cmd);
		}
		System.out.println("==프로그램 종료==");
		sc.close();
	}

}