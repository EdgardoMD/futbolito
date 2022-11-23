package com.futbolito.services.interfaces;

import java.util.List;

public interface ICRUD <T>{
	
	T save(T obj);
	T update(T obj);
	List<T> toList();
	T getById(Long id);
	boolean delete(Long id);
	

}
