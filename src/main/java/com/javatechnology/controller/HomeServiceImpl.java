package com.javatechnology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javatechnology.controller.dao.Login;
import com.javatechnology.controller.dao.Register;

public class HomeServiceImpl implements HomeService{
	@Autowired
	private HomeDao homeDao;
	@Override
	public String validateUserPassword(Login login) {
		// TODO Auto-generated method stub
		return homeDao.validateUserPassword(login);
	}
	@Override
	public String insertUserInfo(Register register) {
		return homeDao.insertUserInfo(register);
	}
	@Override
	public Register updateRegiser(Long id) {
		// TODO Auto-generated method stub
		return homeDao.updateRegiser(id);
	}
	@Override
	public List<Register> getRegisters() {
		// TODO Auto-generated method stub
		return homeDao.getRegisters();
	}
	@Override
	public String deleteRegister(long id) {
		// TODO Auto-generated method stub
		return homeDao.deleteRegister(id);
	}

}
