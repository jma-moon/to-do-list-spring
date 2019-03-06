/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.helpers.responseentitymanager.responseentitybuilder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 * @param <T> response data type
 */
public interface ResponseEntityBuilder<T> {

    public SimpleReponseEntityBuilder<T> setData(T data);
    
    public SimpleReponseEntityBuilder<T> setTotal(Long total);
    
    public SimpleReponseEntityBuilder<T> setError(T error);
    
    public SimpleReponseEntityBuilder<T> setHttpStatus(HttpStatus httpStatus);

    public ResponseEntity build();

}
