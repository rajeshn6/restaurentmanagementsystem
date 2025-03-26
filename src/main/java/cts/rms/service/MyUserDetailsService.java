package cts.rms.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cts.rms.dto.Users;
import cts.rms.repository.UsersRepository;
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users u=usersRepository.findByEmail(username);
		if(u.getEmail()==null) {
			throw new UsernameNotFoundException("User not found exception");
		}
		SimpleGrantedAuthority s=new SimpleGrantedAuthority(u.getRole());
		System.out.println(u.getRole());
		return new User(u.getEmail(), u.getPassword(), true, true, true, true, Arrays.asList(s));
	}

}
