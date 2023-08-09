package com.exammanagament.security;

import com.exammanagament.entity.Student;
import com.exammanagament.repository.StudentRepository;
import com.exammanagament.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

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
