package com.week4.prod_ready_feature.prod_ready_feature.controllers;



import com.week4.prod_ready_feature.prod_ready_feature.clients.Impl.EmployeeClientImpl;
import com.week4.prod_ready_feature.prod_ready_feature.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/restEmployee")
public class EmployeeRestController {

    private final EmployeeClientImpl employeeClient;

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeClient.createNewEmployee(employeeDTO);
    }
    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return employeeClient.getEmployeeById(employeeId);
    }
    @GetMapping
    public List<EmployeeDTO> getAllEmployee(){
        return employeeClient.getAllEmployee();
    }


}
