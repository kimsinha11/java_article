package java_article_make.service;

import java_article_make.container.Container;
import java_article_make.dao.ArticleDao;
import java_article_make.dto.Article;

public class ArticleService {
	private ArticleDao articleDao;

	public ArticleService() {
		this.articleDao = Container.articleDao;
	}

	public void add(Article article) {
		articleDao.add(article);
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return articleDao.size();
	}

	public Article get(int i) {
		// TODO Auto-generated method stub
		return articleDao.get(i);
	}

	public void remove(Article foundArticle) {
		articleDao.remove(foundArticle);
		
	}
}
