package com.ty.pgboot_app.pg_app.util;

import java.util.ArrayList;
import java.util.List;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class ApplicationConfig {

	public Docket getDocket() {
		Contact contact=new Contact("TY","testyantra.com","testyantra@gmail.com");
		List<VendorExtension> extensions =new ArrayList<VendorExtension>();
		ApiInfo apiInfo= new ApiInfo("pgms_app","Boot app for pgms_app","1.0","testyantra.com",contact,"apache tomcat","www.apache.com",extensions);
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ty.pgboot_app.pg_app")).build();
		
	}
}
