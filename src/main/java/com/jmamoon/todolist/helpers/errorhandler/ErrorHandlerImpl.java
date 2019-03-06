/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.helpers.errorhandler;

import com.jmamoon.todolist.exceptions.ResourceNotFoundException;
import com.jmamoon.todolist.helpers.responseentitymanager.ResponseEntityManager;
import com.jmamoon.todolist.helpers.responseentitymanager.ResponseEntityManagerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 */
public class ErrorHandlerImpl implements ErrorHandler {

    public static final String GEMERIC_ERROR = "Something went wrong, please contact system administration.";

    private final ResponseEntityManager responseEntityManager = ResponseEntityManagerFactory.create();

    @Override
    public ResponseEntity getError(Object error) {

        String errorMessage = GEMERIC_ERROR;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if (error instanceof ResourceNotFoundException) {

            errorMessage = ((ResourceNotFoundException) error).getMessage();
            httpStatus = HttpStatus.NOT_FOUND;

        }

        return this.responseEntityManager.createErrorResponse(httpStatus, errorMessage);
    }

}
