package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwtUtils;
import com.example.demo.service.to.UsuarioTO;

@RestController
@RequestMapping("/autorizaciones")
public class AuthorizationControllerRestFul {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwt;

	@GetMapping(path = "/jwt", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtenerToken(@RequestBody UsuarioTO usuario) {
		//Autenticacion
		this.authentication(usuario.getName(), usuario.getPassword());
		return this.jwt.buildTokenJwt(usuario.getName());
	}

	private void authentication(String usuario, String password) {
		UsernamePasswordAuthenticationToken usuarioToken = new UsernamePasswordAuthenticationToken(usuario, password);

		Authentication authentication = authenticationManager.authenticate(usuarioToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

}