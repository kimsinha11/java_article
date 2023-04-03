package java_article_make.container;

import java_article_make.dao.ArticleDao;
import java_article_make.dao.MemberDao;
import java_article_make.service.ArticleService;
import java_article_make.service.ExportService;
import java_article_make.service.MemberService;

public class Container {
	public static ArticleDao articleDao;
	public static MemberDao memberDao;

	public static ArticleService articleService;
	public static MemberService memberService;
	public static ExportService exportService;

	static {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();

		articleService = new ArticleService();
		memberService = new MemberService();
		
		exportService = new ExportService();
	}
}