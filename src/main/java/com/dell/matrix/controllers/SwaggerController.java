package com.dell.matrix.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SwaggerController {

    @ApiOperation("Redirect to swagger UI")
    @GetMapping("/")
    public ModelAndView test() {
        return new ModelAndView("redirect:/swagger-ui.html");
    }

}
