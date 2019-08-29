package service.base;

import org.springframework.beans.factory.annotation.Autowired;

import dao.base.BaseDao;

public class BaseService<T> {

	@Autowired
	private BaseDao<T> dao;
	
	public BaseDao<T> getDao() {
		return dao;
	}

	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	
	public void addNew(T entity){
		System.out.println("addNew by " + dao);
		dao.aa(entity);
	}
	
	public void aa(T entity)
	{
		dao.aa(entity);
	}
	
}
