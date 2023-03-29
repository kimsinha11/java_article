package java_article_make.controller;

import java_article_make.dto.Member;

public abstract class Controller {
	static Member loginedMember = null;

	public boolean isLogined() {
		if (loginedMember == null) {
			return true;
		}
		return false;
	}

	public abstract void doAction(String actionMethodName, String cmd);
}
