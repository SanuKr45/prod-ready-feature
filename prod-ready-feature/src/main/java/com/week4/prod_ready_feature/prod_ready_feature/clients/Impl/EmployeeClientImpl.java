package com.week4.prod_ready_feature.prod_ready_feature.clients.Impl;

import com.week4.prod_ready_feature.prod_ready_feature.advices.ApiResponse;
import com.week4.prod_ready_feature.prod_ready_feature.clients.EmployeeClient;
import com.week4.prod_ready_feature.prod_ready_feature.dto.EmployeeDTO;
import com.week4.prod_ready_feature.prod_ready_feature.exceptions.ResourceNotFound;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
@Service
@RequiredArgsConstructor


public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

//    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);



    @Override
    public List<EmployeeDTO> getAllEmployee() {

//        log.trace("Trying to retrieve list of all employee");
        try {

            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res)->{
//                        log.error(new String((res.getBody().readAllBytes())));
                        throw new ResourceNotFound("Employee list not found");

                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
//            log.debug("Successfully retrieved all employee in getAllEmployee");
//            log.trace("Retrieved All employee in getAllEmployee: {}", employeeDTOList.getData());
            return employeeDTOList.getData();
        }
        catch (Exception e){
//            log.error("Exception occurred in gelAllEmployee");
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
//        log.trace("Trying to retrieve the id of employee");
        try {

            ApiResponse<EmployeeDTO> employeeResponse = restClient.get()
                    .uri("employees/{employeeId}",employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res)->{
//                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFound("ID not found");
                    })
                    .body(new ParameterizedTypeReference<>(){
                    });
//            log.debug("Successfully retrieved the id of employee ");
//            log.trace("Retrieved Id employee in geEmployeeById: {}", employeeId);
            return employeeResponse.getData();
        }

        catch (Exception e){
//            log.error("Exception occurred in getAllEmployee ",e);
            throw new RuntimeException(e);
        }

        }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
//        log.trace("Creating a new employee");
//        log.info("attempting to create new employee");
        try{


            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.post()
                    .uri("employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res)->{
//                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFound("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
            });
//            log.debug("Employee created");
//            log.trace("Successfully created the employee: {}", employeeDTOApiResponse.getData());
            return employeeDTOApiResponse.getData();


        }
        catch(Exception e){
//            log.error("Exception occurred in creating employee in createNewEmployee");
            throw new RuntimeException(e);
        }
    }


}
