package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.dao.impl.BucketDaoImpl;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.service.BucketService;

public class BucketServiceImpl implements BucketService{
	private BucketDao bucketDao;

	public BucketServiceImpl() {
		try {
			bucketDao = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Bucket create(Bucket obj) {
		return bucketDao.create(obj);
	}

	@Override
	public Bucket update(Bucket obj) {
		return bucketDao.update(obj);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
		
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public List<Bucket> readall() {
		return bucketDao.readall();
	}
	
	
}
