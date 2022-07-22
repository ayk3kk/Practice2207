package jp.co.worldss;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DrinkData {

	@Id
	private int number;
	private String product;
	private int price;
	private Boolean status;

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}



}
