package java_article_make.dao;

import java.util.ArrayList;
import java.util.List;

import java_article_make.dto.Article;

public class ArticleDao {
	public static List<Article> articles;

	public ArticleDao() {
		articles = new ArrayList<>();
	}

	public void add(Article article) {
		articles.add(article);
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return articles.size();
	}

	public Article get(int i) {
		// TODO Auto-generated method stub
		return articles.get(i);
	}

	public void remove(Article foundArticle) {
		articles.remove(foundArticle);
		
	}
}
