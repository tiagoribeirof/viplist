package com.devservice.viplist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devservice.viplist.model.Invited;
import com.devservice.viplist.repository.InvitedRepository;

@Service
public class InvitedService {
	
	@Autowired
	private InvitedRepository repository;
	
	public Iterable<Invited> getAll(){
		
		Iterable<Invited> invitedList = repository.findAll();
		
		return invitedList;
		
	}
	
	
	public void save(Invited invited){
		repository.save(invited);
	}

}
