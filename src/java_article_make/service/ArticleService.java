package java_article_make.service;

import java.util.List;

import java_article_make.container.Container;
import java_article_make.dao.ArticleDao;
import java_article_make.dto.Article;

public class ArticleService {
	private ArticleDao articleDao;
	
	public ArticleService() {
		this.articleDao = Container.articleDao;
	}
	public List<Article> getforPrintArticles(String searchKeyword) {
		List<Article> articles = Container.articleDao.getArticles(searchKeyword);
		return articles;
	} 
	
	public int setNewId() {
		
		int id = articleDao.setNewId();
		return id;
	}
	public void add(Article article) {
	
		articleDao.add(article);
	}
	public Article getArticleById(int id) {
		
		return articleDao.getArticleById(id);
	}
	public void remove(Article foundArticle) {
		articleDao.remove(foundArticle);
		
	}
	public List<Article> getForPrintArticles() {
		// TODO Auto-generated method stub
		return null;
	}

}
