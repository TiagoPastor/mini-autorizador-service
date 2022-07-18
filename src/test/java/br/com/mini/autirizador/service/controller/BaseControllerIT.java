package br.com.mini.autirizador.service.controller;

import java.util.Locale;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.javafaker.Faker;

import br.com.mini.autirizadorservice.MiniAutorizadorServiceApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {MiniAutorizadorServiceApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "/application-integrationtest.yml")
public class BaseControllerIT {
	
	
	public static final Faker faker = new Faker(new Locale("pt", "BR"));
	
	
	@Autowired 
	TestRestTemplate restTemplate;

}
