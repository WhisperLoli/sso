package com.java.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 同级域名单点登录(即同一个项目中不同模块，也可以使用session实现单点登录，但是分布式得共享session,不如cookie)
 * @author HNJ
 *
 */
@SpringBootApplication
public class SsoSameDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoSameDomainApplication.class, args);
	}
}
