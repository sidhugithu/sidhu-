package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Signup;
import com.example.demo.repository.SignupRepository;

@Service
public class SignupService {
	
	@Autowired 
	private SignupRepository signuprepo;
	
	public Signup saveSignup(Signup signup) {
		return signuprepo.save(signup);
	}

	public String checkLogin(String email, String password) {
		Signup ss = signuprepo.findByEmailAndPassword(email,password);
		if(ss!=null) {
			if(ss.getEmail().equalsIgnoreCase(email) && ss.getPassword().equals(password)) {
				return "true:"+ss.getUser();
			}
			else {
				return "false";
			}
		}
		else {
			return "false";
		}
	}
	
}
