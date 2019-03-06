/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.helpers.responseentitymanager;

import com.jmamoon.todolist.helpers.responseentitymanager.responseentitybuilder.ResponseEntityBuilderFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 */
public class SimpleResponseEntityManager implements ResponseEntityManager {

    @Override
    public ResponseEntity createSingleResponse(HttpStatus httpStatus, Object data) {
        return ResponseEntityBuilderFactory.create()
                .setData(data)
                .setHttpStatus(httpStatus)
                .build();
    }

    @Override
    public ResponseEntity createMultipleResponse(HttpStatus httpStatus, Object data, Long total) {
        return ResponseEntityBuilderFactory.create()
                .setData(data)
                .setTotal(total)
                .setHttpStatus(httpStatus)
                .build();
    }

    @Override
    public ResponseEntity createErrorResponse(HttpStatus httpStatus, Object error) {
        return ResponseEntityBuilderFactory.create()
                .setError(error)
                .setHttpStatus(httpStatus)
                .build();
    }
    
}
