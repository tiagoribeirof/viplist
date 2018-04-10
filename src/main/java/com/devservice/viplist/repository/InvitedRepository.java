package com.devservice.viplist.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.devservice.viplist.model.Invited;

public interface InvitedRepository extends CrudRepository<Invited, Long> {
	
	
	List<Invited> findByName(String name);

}
