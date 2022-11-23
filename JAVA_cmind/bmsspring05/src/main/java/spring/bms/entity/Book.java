package spring.bms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="bookinfo")
public class Book {
	//ISBN
	@Id
	@Column(length = 20)
	@NotEmpty(message="ISBNを入力してください")
	private String isbn;
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	//タイトル
	@Column(length = 100, nullable = true)
	@NotEmpty(message="タイトルを入力してください")
	private String title;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	//価格
	@Column(length = 11, nullable = true)
	@NotEmpty(message="価格を入力してください")
	private String price;
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
}
