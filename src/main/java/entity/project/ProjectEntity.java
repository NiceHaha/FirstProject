package entity.project;


import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class ProjectEntity {
	private int id;
	//值必须大(小)于等于指定的值
	@Min(50)
	private String article_code; //编号
	@NotEmpty
	private String article_title;  //标题
	private String article_text;  //正文
	private String goods_code;    //商品编号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArticle_code() {
		return article_code;
	}
	public void setArticle_code(String article_code) {
		this.article_code = article_code;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_text() {
		return article_text;
	}
	public void setArticle_text(String article_text) {
		this.article_text = article_text;
	}
	public String getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", article_code=" + article_code + ", article_title=" + article_title
				+ ", article_text=" + article_text + ", goods_code=" + goods_code + "]";
	}
	
	
	
	
}
