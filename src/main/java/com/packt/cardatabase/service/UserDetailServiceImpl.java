package com.packt.cardatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User currentUser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPassword()
                , true, true, true, true, AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }

}

//7.      We have to inject the UserRepository class into the UserDetailServiceImpl class because that is needed to fetch the user from the database when Spring Security handles authentication. The loadByUsername method returns the UserDetails object, which is required for authentication.
//        The following is the source code of UserDetailServiceImpl.java: