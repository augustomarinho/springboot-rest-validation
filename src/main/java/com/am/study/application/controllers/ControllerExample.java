package com.am.study.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

/**
 * Created by augustomarinho on 26/03/17.
 */
@RestController
@Validated
public class ControllerExample {

    @RequestMapping(value = "/query/cpf/{cpf}", method = RequestMethod.GET)
    public ResponseEntity<String> queryByCPF(@Pattern(regexp = "\\d{9}", message = "Deve conter 9 digitos") @PathVariable String cpf) {
        try {
            return new ResponseEntity<String>("OK", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
