package java_article_make.controller;

import java_article_make.dto.Member;

public abstract class Controller {
	
	public static Member loginedMember = null;
	public boolean isLogined() {
		return loginedMember != null;
	}
	
	
	public abstract void doAction(String actionMethodName, String command);

	public void makeTestData() {

	}
}