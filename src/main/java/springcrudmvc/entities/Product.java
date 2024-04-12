package springcrudmvc.entities;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String productNameString;
	public String productDescString;
	public long productPrice;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductNameString() {
		return productNameString;
	}
	public void setProductNameString(String productNameString) {
		this.productNameString = productNameString;
	}
	public String getProductDescString() {
		return productDescString;
	}
	public void setProductDescString(String productDescString) {
		this.productDescString = productDescString;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productNameString=" + productNameString + ", productDescString="
				+ productDescString + ", productPrice=" + productPrice + "]";
	}
	
	
}
