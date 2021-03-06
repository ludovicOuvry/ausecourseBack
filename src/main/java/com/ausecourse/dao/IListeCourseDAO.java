package com.ausecourse.dao;

import java.util.List;

import com.ausecourse.model.ListeCourse;


public interface IListeCourseDAO {
	public List<ListeCourse> findAll();
	public ListeCourse findById(String id);
	public String save(ListeCourse list);
	public List<ListeCourse> getAllByIdClient(String mail);
	public void delete(String id);


}
