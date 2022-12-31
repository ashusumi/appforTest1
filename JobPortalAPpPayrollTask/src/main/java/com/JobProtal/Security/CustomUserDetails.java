package com.JobProtal.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.JobProtal.Entity.User;
import com.JobProtal.Repository.UserRepository;

@Component
public class CustomUserDetails implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=repository.findByUsername(username);
		System.out.println(user);
		if(user==null) {
			throw new UsernameNotFoundException(username+"not found");
		}
		return new CustomUser(user);
	}

}
