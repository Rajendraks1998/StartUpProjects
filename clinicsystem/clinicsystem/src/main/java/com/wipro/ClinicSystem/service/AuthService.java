package com.wipro.ClinicSystem.service;


import com.wipro.ClinicSystem.dao.AdminDao;
import com.wipro.ClinicSystem.model.Admin;
import jakarta.servlet.http.HttpSession;

public interface AuthService {
	public Admin save(Admin users);

	boolean checkLogin(AdminDao userDao, HttpSession sess);
}
