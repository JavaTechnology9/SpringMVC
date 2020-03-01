package com.javatechnology.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javatechnology.controller.dao.Login;
import com.javatechnology.controller.dao.Register;
@Service
public interface HomeService {
	public String validateUserPassword(Login login);
	public String insertUserInfo(Register register);
	public Register updateRegiser(Long id);
	public List<Register> getRegisters();
	public String deleteRegister(long id);
}
