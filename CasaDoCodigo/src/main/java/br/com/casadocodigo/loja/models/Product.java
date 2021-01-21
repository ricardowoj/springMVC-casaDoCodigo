package br.com.casadocodigo.loja.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/*• @Entity: indica que a classe vai virar uma tabela.
• @Id: indica que o atributo em questão é a chave primária.
• @GeneratedValue: indica amaneira como vai ser gerada a chave primária.
• @Lob: indica que o atributo em questão vai ser salvo como Clob ou
Blob no banco de dados.*/
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@Lob
	private String description;
	private int pages;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
}
