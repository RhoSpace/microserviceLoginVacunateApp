package com.vacunateapp.usuarios.controller;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class UsuarioController{

	@GetMapping("/auth")
	public Principal user(Principal user) {
		return user;
	}

}