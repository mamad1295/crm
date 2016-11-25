package com.mamad.service;
import java.util.List;

import com.mamad.model.administration.Workgroup;




public interface WorkgroupService {
	public List<Workgroup> getAll();
	
	public Workgroup getById(int id);
	
	public void save(Workgroup workgroup);
	public void update(Workgroup workgroup);
	
	public void delete(int id);

	public void saveOrUpdate(Workgroup wg);
	public List<Workgroup> list();
}

