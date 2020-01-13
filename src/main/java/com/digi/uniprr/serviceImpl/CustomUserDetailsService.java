
package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.LoggedUser;
import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.UserLoginRepo;

@Service("customUserDetailsService")

@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserLoginRepo userLoginRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userLoginRepo.findByusername(username);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}

		UserDetails userDetails = new LoggedUser(user.getId(), user.getUsername(), user.getPassword(),
				user.getFirstName(), user.getLastName(), user.getEmail(), getGrantedAuthorities(user));
		return userDetails;
	}

	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
		User user = userLoginRepo.findByusername(email);
		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}

		UserDetails userDetails = new LoggedUser(user.getId(), user.getUsername(), user.getPassword(),
				user.getFirstName(), user.getLastName(), user.getEmail(), getGrantedAuthorities(user));
		return userDetails;
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getGroups().getRole().getRoleName()));
		return authorities;
	}

}
