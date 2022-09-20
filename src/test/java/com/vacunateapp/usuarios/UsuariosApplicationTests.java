package com.vacunateapp.usuarios;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.vacunateapp.usuarios.model.User;
import com.vacunateapp.usuarios.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class UsuariosApplicationTests {
	@Autowired
	private UserRepository usuariorepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	  /*this.id = id;
      this.name = name;
      this.rut = rut;
      this.phone = phone;
      this.email = email;
      this.password = password;*/
    @Test
    void crearUser() {
		User user = new User();
		user.setName("jebuz");
		user.setRut("199264646");
		user.setPhone("123456");
		user.setEmail("dan@gmail.com");
		user.setPassword(encoder.encode("123"));
		user.setRole(true);
		User retorno = usuariorepository.save(user);

    }
}
