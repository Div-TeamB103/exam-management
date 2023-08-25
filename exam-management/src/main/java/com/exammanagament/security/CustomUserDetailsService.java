package com.exammanagament.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService  implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        Student usersEntity = userService.findStudentByEmail(username)
//
//
//        Set<GrantedAuthority> authorities = usersEntity
//                .getRoles()
//                .stream()
//                .map((role)-> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toSet());
//
//        return new User(usersEntity.getuName(), usersEntity.getuPassword() , authorities);
        return null;
    }
}
