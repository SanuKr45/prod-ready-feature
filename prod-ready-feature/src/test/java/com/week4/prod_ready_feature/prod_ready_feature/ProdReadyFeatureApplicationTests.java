package com.week4.prod_ready_feature.prod_ready_feature;

import com.week4.prod_ready_feature.prod_ready_feature.clients.EmployeeClient;
import com.week4.prod_ready_feature.prod_ready_feature.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProdReadyFeatureApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void getAllEmployeeTest(){
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployee();
		System.out.println(employeeDTOList);
	}

	@Test
	void getEmployeeByIdTest(){
		EmployeeDTO employeeDTO = employeeClient.getEmployeeById(1L);
		System.out.println(employeeDTO);
	}
	@Test
	void createNewEmployeeTest(){
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "Sanu", "sanu@gmail.com", 20, "USER", 5000.00, LocalDate.of(2020,12,10),true);
		EmployeeDTO savedEmployeeDTO = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDTO);
	}

}
