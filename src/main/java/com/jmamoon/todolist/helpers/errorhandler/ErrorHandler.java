/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.helpers.errorhandler;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 */
public interface ErrorHandler {

    public ResponseEntity getError(Object error);

}
