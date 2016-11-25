package com.mamad.dao.administration;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mamad.model.administration.Workgroup;
 
/**
 * This class implements the WorkgroupDao's opretaions (crud)
 * It uses a sessionFactory object to accomplish hibernate operations'
 * @author Mamadou
 *
 */
@Repository
public class WorkgroupDaoImpl implements WorkgroupDao {
     
	@Autowired
    private SessionFactory sessionFactory;
	
	
	public WorkgroupDaoImpl(){
		
	}
	
	//@Autowired
    public WorkgroupDaoImpl(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
	}
	public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    @Transactional
    public void save(Workgroup workgroup) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(workgroup);
    }
    @Transactional
    public void update(Workgroup workgroup) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(workgroup);
    }
    /**
     * This method gets all workgroup from the db 
     * by using HQL method createQuery which uses persists class name instead of table name
     * and property name instead of column 
     */
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Workgroup> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Workgroup> wgList = (List<Workgroup>)session.createQuery("from Workgroup").list();
        for(Workgroup workgroup : wgList){
        	System.out.println("info: "+workgroup);
        }
        return wgList;
    }
    /**
     * This method uses the hibernate's session.load() method to get 
     * Workgroup object
     * @return Workgroup object
     */
    @Transactional
    public Workgroup getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Workgroup workgroup = (Workgroup) session.load(Workgroup.class, new Integer(id));
        return workgroup;
    }
    /**
     * removing a workgroup object from the db by its id, 
     * using the session.load() method
     */
    @Transactional
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        //using session to load Workgroup class identified by the id 
        //(it's a hibernate method, seems like session.get() wich returns null
        //if object was not found
        Workgroup workgroup = (Workgroup) session.load(Workgroup.class, new Integer(id));
        if(null != workgroup){
            session.delete(workgroup);
        }
    }
    /**
     * This method can do 2 opertaions: 
     * if the object is present in the db, it will updated
     * else save will excuted
     */
    @Transactional
	public void saveOrUpdate(Workgroup wg) {
		sessionFactory.getCurrentSession().saveOrUpdate(wg);
	}
    /**
     * This method obtains the current session from the SessionFactory and 
     * queries all workgroup in the db 
     */
    @Transactional
	public List<Workgroup> list() {
		@SuppressWarnings("unchecked")
		List<Workgroup> listWorkgroup = (List<Workgroup>) sessionFactory.getCurrentSession()
				.createCriteria(Workgroup.class)
				//stands for a select * from workgroup
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
				//this can be used to add some conditions using .add(Expression...());

		return listWorkgroup;
	}


 
}
