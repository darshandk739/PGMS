package com.ty.pgboot_app.pg_app;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.pgboot_app.pg_app.dto.Admin;
import com.ty.pgboot_app.pg_app.repo.AdminRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class PgAppApplicationTests {

	//private Calculator c = new Calculator();	
	@Autowired
	
	AdminRepository adminRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@Order(1)
	public void testCreate() {
		Admin admin = new Admin(); 
		admin.setAdminId(50);
		admin.setAdminName("abc1243");
		admin.setAdminUserName("hello123");
		admin.setAdminEmail("abc@mail.com");
		admin.setAdminPassword("234");
		adminRepository.save(admin);
		assertNotNull(adminRepository.findById(11).get());
	}
	
	@Test
	@Order(2)
	public void testReadAll() {
		List<Admin> list = adminRepository.findAll();
		//assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testSingleAdmin() {
		Admin admin = adminRepository.findById(2).get();
		assertEquals("123", admin.getAdminPassword());
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		Admin admin = adminRepository.findById(11).get();
		admin.setAdminPassword("777");
		adminRepository.save(admin);
		assertNotEquals(234, adminRepository.findById(11).get().getAdminPassword());
		
	}
	
	@Test
	@Order(5)
	public void testDelete() {
		adminRepository.deleteById(11);
		//assertThat(adminRepository.existsById(13).isFalse());
	}
	
//	@Test
//	//@Disabled
//	void testSum() {
//		//expected
//		int expectedResult = 17;
//		
//		//actual
//		int actualResult = c.doSum(12, 3, 2);
//		//assertThat(actualResult)actualResult.;
//	}
//	
//	@Test
//	void testProduct() {
//		//expected
//		int expectedResult = 6;
//		//actual
//		int actualResult = c.doProduct(3, 2);
//	}
//	
//	@Test
//	void testCompareNums() {
//		//actual result
//		Boolean actualResult = c.compareTwoNums(3, 3);
//		
//	}
	
	
	
	

}
