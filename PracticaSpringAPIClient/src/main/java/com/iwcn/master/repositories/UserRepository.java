package com.iwcn.master.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iwcn.master.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {
	User findByUser(String user);
}
