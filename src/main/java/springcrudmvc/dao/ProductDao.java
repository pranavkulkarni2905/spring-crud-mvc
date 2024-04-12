package springcrudmvc.dao;

import java.io.Serializable;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import springcrudmvc.entities.Product;

@Component
public class ProductDao {

	@Autowired
	public HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	public List<Product> getAllProducts(){
		List<Product> list = this.hibernateTemplate.loadAll(Product.class);
		return list;
	}
	
	@Transactional
	public void deleteProduct(int id) {
		Product product = this.hibernateTemplate.get(Product.class, id);
		this.hibernateTemplate.delete(product);
	}
	
	
	public Product getSingleProduct(int id) {
		return this.hibernateTemplate.get(Product.class, id);
	}
	
	
}
