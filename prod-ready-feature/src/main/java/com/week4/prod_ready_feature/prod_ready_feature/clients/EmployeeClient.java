package com.week4.prod_ready_feature.prod_ready_feature.clients;

import com.week4.prod_ready_feature.prod_ready_feature.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);

}
