package com.vacunateapp.usuarios.repository;

import com.vacunateapp.usuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByRut(String rut);
    
    /*public void save(Usuario usuario) {
    	
    }*/
}
