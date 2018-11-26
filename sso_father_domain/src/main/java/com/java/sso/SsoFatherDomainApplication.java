package com.java.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 同父域（demo1.x.com,demo2.x.com,check.x.com）SSO
 * @author HNJ
 *
 */
@SpringBootApplication
public class SsoFatherDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoFatherDomainApplication.class, args);
	}
}
