package com.wipro.ClinicSystem.serviceimpl;

import java.util.Optional;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ClinicSystem.dao.AdminDao;
import com.wipro.ClinicSystem.model.Admin;
import com.wipro.ClinicSystem.repository.AuthRepository;
import com.wipro.ClinicSystem.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthRepository authRepository;

	@Override
	public Admin save(Admin users) {
		return authRepository.save(users);
	}

	@Override
	public boolean checkLogin(AdminDao userDao, HttpSession sess) {
		Optional<Admin> users = authRepository.findByAdminnameAndAdminpassword(userDao.getAdminname(), userDao.getAdminpassword());
		if(users.isPresent())
		{
			Admin user = users.get();
			System.out.println(user);
			sess.setAttribute("name", user.getAdminname());
			sess.setAttribute("userType", "user");
			sess.setAttribute("userId", user.getAdminid());
			return true;
		}
		else
			return false;
	}


}
