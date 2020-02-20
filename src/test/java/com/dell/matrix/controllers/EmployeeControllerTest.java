package com.dell.matrix.controllers;

import com.dell.matrix.models.Employee;
import com.dell.matrix.services.EmployeeService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EmployeeService employeeService;

    @Test
    @DisplayName("CheckIn route - All parameters met")
    public void test_check_in_all_parameters_met() {

        Long employeeBadge = 1l;

        Employee employeeMock = Employee.builder()
                .badge(employeeBadge)
                .name("Mock employee")
                .role("Intern")
                .build();

        given(this.employeeService.getEmployeeByBadge(any(Long.class)))
                .willReturn(any(Employee.class));

        RestAssuredMockMvc.given().
                mockMvc(mockMvc).
                contentType(ContentType.JSON).
        when().
                get("/employees" + employeeBadge).
         then().
                log().all(true).
                assertThat().
                statusCode(HttpStatus.OK.value()).
                contentType(ContentType.JSON);
    }
}
