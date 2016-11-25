package com.mamad.dao;

import java.util.List;
/**
 * This class will be extended by other dao class. It contains all basic operations
 * for an object
 * @author Mamad
 *
 * @param <T>
 */
public interface MainDao<T> {
		  public abstract boolean save(T object);
		  public abstract boolean deleteObject(T object);
		  public abstract boolean delete(int id);
		  public abstract boolean update(T object);
		  public abstract boolean saveOrUpdate(T object);
		  public abstract T getById(int id);
		  public abstract List<T> getAll();

}
