/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.helpers.responseentitymanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 */
public interface ResponseEntityManager {

    public <T> ResponseEntity createSingleResponse(HttpStatus httpStatus, T data);

    public <T> ResponseEntity createMultipleResponse(HttpStatus httpStatus, T data, Long total);

    public <T> ResponseEntity createErrorResponse(HttpStatus httpStatus, T error);

}
