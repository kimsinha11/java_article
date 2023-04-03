package java_article_make.service;

import java.util.List;

import java_article_make.container.Container;
import java_article_make.dto.Article;
import java_article_make.util.Util;

public class ExportService {
	ArticleService articleService;
	MemberService memberService;

	public ExportService() {
		articleService = Container.articleService;
		memberService = Container.memberService;
	}

	public void makeHtml() {
		List<Article> articles = articleService.getForPrintArticles();

		for (Article article : articles) {
			String writerName = memberService.getMemberNameById(article.memberId);

			String fileName = article.id + ".html";
			String html = "<meta charset=\"UTF-8\">";
			html += "<div>번호 : " + article.id + "</div>";
			html += "<div>날짜 : " + article.regDate + "</div>";
			html += "<div>작성자 : " + writerName + "</div>";
			html += "<div>제목 : " + article.title + "</div>";
			html += "<div>내용 : " + article.body + "</div>";
			if (article.id > 1) {
				html += "<div><a href=\"" + (article.id - 1) + ".html\">이전글</a></div>";
			}

			html += "<div><a href=\"" + (article.id + 1) + ".html\">다음글</a></div>";

			Util.writeFileContents("exportHtml/" + fileName, html);
		}
	}

}