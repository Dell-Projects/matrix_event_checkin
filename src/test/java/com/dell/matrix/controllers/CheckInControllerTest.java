package com.dell.matrix.controllers;

import com.dell.matrix.models.EmployeeEvent;
import com.dell.matrix.models.transition.CheckInRequest;
import com.dell.matrix.services.CheckInService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebMvcTest
public class CheckInControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CheckInService checkInService;

    @Test
    @DisplayName("CheckIn route - All parameters met")
    public void test_check_in_all_parameters_met() {

        CheckInRequest mockCheckInRequest = CheckInRequest.builder()
                .employeeBadge(1l)
                .eventId(1l)
                .build();

        given(this.checkInService.checkInEvents(mockCheckInRequest))
                .willReturn(any(EmployeeEvent.class));

        given().
                mockMvc(mockMvc).
                contentType(ContentType.JSON).
        when().
                get("/checkin").
         then().
                log().all(true).
                assertThat().
                statusCode(HttpStatus.OK.value()).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("CheckIn route - Missing parameters")
    public void test_check_in_missing_parameters() {

    }
}
