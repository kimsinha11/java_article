package java_article_make.dao;

public abstract class Dao {
	protected int lastId;
//	public Dao() {
//		lastId = 0;
//	} 
	public abstract int getLastId();
}
