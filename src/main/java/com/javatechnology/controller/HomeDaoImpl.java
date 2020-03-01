package com.javatechnology.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.javatechnology.controller.dao.Login;
import com.javatechnology.controller.dao.Register;

public class HomeDaoImpl implements HomeDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	private static final String getLogin="from Login where userName=? and password=?";
	
	private static final String insertOBject="from Login where userName=? and password=?";
	@Override
	public String validateUserPassword(Login login) {
		List<Login> loginDetails=(List<Login>) hibernateTemplate.find(getLogin, login.getUserName(),login.getPassword());
		return !loginDetails.isEmpty()?"successful":"login failure";
	}
	@Override
	//@Transactional
	public String insertUserInfo(Register register) {
		hibernateTemplate.saveOrUpdate("Register",register);
		//hibernateTemplate.cre
		return null;
	}
	String sql123="from Register where id=?";
	@Override
	public Register updateRegiser(Long id) {
		@SuppressWarnings("unchecked")
		List<Register> regiser=(List<Register>) hibernateTemplate.find(sql123, id);
		return !regiser.isEmpty()?regiser.get(0):null;
	}
	String sql="update register set email=? where id=123";
	String getRegisters="from Register";
	@Override
	public List<Register> getRegisters() {
		Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(getRegisters);
		
		return !query.list().isEmpty()? query.list():null;
	}
	String deleteSQL="delete from Register where id=?";
	//hibernateTemplate.delete(hibernateTemplate.get(Class,Id));
	@Override
	public String deleteRegister(long id) {
		hibernateTemplate.delete((Register)hibernateTemplate.get(Register.class, id));
		return "Deleted Succesfully";
	}

}
