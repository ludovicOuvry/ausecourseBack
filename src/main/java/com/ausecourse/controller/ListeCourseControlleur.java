package com.ausecourse.controller;

import java.util.HashMap;

import java.util.List;

import javax.swing.tree.ExpandVetoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ausecourse.dao.IListeCourseDAO;
import com.ausecourse.dao.IOrderDAO;
import com.ausecourse.dao.IUserDao;
import com.ausecourse.model.ListeCourse;
import com.ausecourse.model.Order;
import com.ausecourse.model.Product;
import com.ausecourse.model.User;

@RestController
@RequestMapping("/ListeCourse")
public class ListeCourseControlleur {
//routes

	@Autowired
	private IUserDao userDao;
	@Autowired
	private IOrderDAO orderDao;
	@Autowired
	private IListeCourseDAO listeCourseDao;

	@RequestMapping(value = "/getAllByIdClient", method = RequestMethod.GET)
	public List<ListeCourse> getAllByIdClient(@RequestBody String mail) throws Exception {
		List<ListeCourse> listeCourse = null;

		try {
			listeCourse= listeCourseDao.getAllByIdClient(mail);
		} catch (ExceptionInInitializerError e) {
			System.err.println(e.getCause()+e.getMessage());
			return null;

		}

		return listeCourse;

	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	public ListeCourse getById(@RequestBody String id) throws Exception {
		ListeCourse listeCourse = null;

		try {
			listeCourse= listeCourseDao.findById(id);
		} catch (ExceptionInInitializerError e) {
			System.err.println(e.getCause()+e.getMessage());
			return null;

		}

		return listeCourse;

	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestBody ListeCourse l) throws Exception {
		List<ListeCourse> listeCourse = null;
		String rep = null;
		
//		HashMap<String, Integer> hm = new HashMap<>();
//		hm.put("pain", 1);
//		hm.put("confiture",2);
//		 ListeCourse l = new ListeCourse(null,"mailCli",hm);
		try {
			rep = listeCourseDao.save(l);
		} catch (ExceptionInInitializerError e) {
			System.err.println(e.getCause()+e.getMessage());
			return null;

		}

		return rep;

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestBody ListeCourse l) throws Exception {
		List<ListeCourse> listeCourse = null;
		String rep = null;
		try {
			rep = listeCourseDao.save(l);
		} catch (ExceptionInInitializerError e) {
			System.err.println(e.getStackTrace());
			return null;

		}

		return rep;

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity delete(@RequestBody String ListeCourseID) throws Exception {
		List<ListeCourse> listeCourse = null;
		String rep = null;
		try {
			listeCourseDao.delete(ListeCourseID);
		} catch (Exception e) {
			System.err.println(e.getCause()+e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity(HttpStatus.OK);


	}
	

}