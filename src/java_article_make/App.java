package java_article_make;

import java.util.Scanner;

import java_article_make.controller.ArticleController;
import java_article_make.controller.Controller;
import java_article_make.controller.MemberController;

public class App {
	App() {
	}

	public void start() {

		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
		Controller controller = null;
		
		memberController.maketestdata();
		articleController.maketestdata();

		while (true) {
			System.out.printf("명령어 >> ");
			String command = sc.nextLine().trim();

			if (command.equals("exit")) {
				break;
			}
			String[] commandDiv = command.split(" ");

			String controllerName = commandDiv[0];

			if (commandDiv.length == 1) {
				System.out.println("명령어를 확인해주세요.");
				continue;
			}

			String actionMethodName = commandDiv[1];

			if (controllerName.equals("article")) {
				controller = articleController;
			} else if (controllerName.equals("member")) {
				controller = memberController;
			} else {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}

			controller.doAction(actionMethodName, command);

		}
		System.out.println("==프로그램 종료==");

	}

}
