package com.mamad.service;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mamad.dao.administration.WorkgroupDao;
import com.mamad.model.administration.Workgroup;

/**
 * Service classe using WorkgroupDao for work with Workgroup object, we have at least 
 * the same operations in the WorkgroupDao + eventually other operations... 
 * @author Mamadou
 *
 */

@Service
public class WorkgroupServiceImpl implements WorkgroupService {
     
	@Autowired
    private WorkgroupDao workgroupDao;
    
    SessionFactory sessionFactory;
    public WorkgroupServiceImpl(){
    	
    }
    
    @Autowired
    public WorkgroupServiceImpl(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
	}
 
    public void setWorkgroupDao(WorkgroupDao workgroupDao) {
        this.workgroupDao = workgroupDao;
    }
 
    @Transactional
    public void save(Workgroup workgroup) {
        this.workgroupDao.save(workgroup);
    }
 
    @Transactional
    public void update(Workgroup workgroup) {
        this.workgroupDao.update(workgroup);
    }
 
    @Transactional
    public List<Workgroup> getAll() {
        return this.workgroupDao.getAll();
    }
 
    @Transactional
    public Workgroup getById(int id) {
        return this.workgroupDao.getById(id);
    }
 
    @Transactional
    public void delete(int id) {
        this.workgroupDao.delete(id);
    }

  //2 methods to review
    @Transactional
	public void saveOrUpdate(Workgroup wg) {
		sessionFactory.getCurrentSession().saveOrUpdate(wg);
	}
    
    @Transactional
	public List<Workgroup> list() {
		return workgroupDao.list();
	}
}