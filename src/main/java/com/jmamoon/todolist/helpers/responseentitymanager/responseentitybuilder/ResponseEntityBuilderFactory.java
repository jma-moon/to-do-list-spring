/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.helpers.responseentitymanager.responseentitybuilder;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 */
public class ResponseEntityBuilderFactory {

    public static <T> ResponseEntityBuilder create() {

        return new SimpleReponseEntityBuilder<T>();
    }

}
