/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.helpers.responseentitymanager.responseentitybuilder;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 * @param <T> response data type
 */
public class SimpleReponseEntityBuilder<T> implements ResponseEntityBuilder<T> {

    private Map<String, Object> responseData;
    private HttpStatus httpStatus;

    public SimpleReponseEntityBuilder() {

        this.responseData = new HashMap<>();
    }

    @Override
    public SimpleReponseEntityBuilder<T> setData(T data) {

        this.responseData.put("data", data);
        return this;
    }

    @Override
    public SimpleReponseEntityBuilder<T> setTotal(Long total) {
        this.responseData.put("total", total);
        return this;
    }

    @Override
    public SimpleReponseEntityBuilder<T> setError(T error) {
        this.responseData.put("error", error);
        return this;
    }

    @Override
    public SimpleReponseEntityBuilder<T> setHttpStatus(HttpStatus httpStatus) {

        this.httpStatus = httpStatus;
        return this;
    }

    @Override
    public ResponseEntity build() {

        return new ResponseEntity(this.responseData, this.httpStatus);
    }

}
