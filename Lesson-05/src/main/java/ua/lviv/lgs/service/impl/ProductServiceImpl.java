package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.dao.impl.ProductDaoImpl;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;

public class ProductServiceImpl implements ProductService{
	private ProductDao productDao;
	
	

	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
		
	}

	@Override
	public Product create(Product obj) {
		return productDao.create(obj);
	}

	@Override
	public Product update(Product obj) {
		return productDao.update(obj);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
		
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public List<Product> readall() {
		return productDao.readall();
	}

}
