package br.gov.ba.pm.sgeapm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.gov.ba.pm.sgeapm.service.EmailService;

@SpringBootApplication
public class SgeApmApplication {
	

	@Autowired
	EmailService service;	
	

	public static void main(String[] args) {
		//System.out.println(new BCryptPasswordEncoder().encode("1234"));
		SpringApplication.run(SgeApmApplication.class, args);
		
	}
	/*
	public void run(String... args) throws Exception {
		//s3.uploadFile("C:\\temp\\brasao-turma.jpeg");
		System.out.println(pe.encode("123"));
		}


	*/

}
