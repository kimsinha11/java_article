package java_article_make.controller;

import java.util.Scanner;

import java_article_make.container.Container;
import java_article_make.service.ExportService;

public class ExportController extends Controller {
	private Scanner sc;
	private String command;
	private String actionMethodName;
	private ExportService exportService;

	public ExportController(Scanner sc) {
		this.sc = sc;
		exportService = Container.exportService;
	}

	public void doAction(String actionMethodName, String command) {
		this.command = command;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "html":
			doHtml();
			break;
		default:
			System.out.println("존재하지 않는 명령어 입니다.2");
			break;
		}
	}

	@Override
	public String toString() {
		return "ExportController [sc=" + sc + ", command=" + command + ", actionMethodName=" + actionMethodName
				+ ", exportService=" + exportService + "]";
	}

	private void doHtml() {
		System.out.println("== html 생성을 시작합니다. ==");
		exportService.makeHtml();
	}

	public void makeTestData() {

	}
}