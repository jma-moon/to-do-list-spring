/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.helpers.responseentitymanager;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 */
public class ResponseEntityManagerFactory {

    public static ResponseEntityManager create() {
        return new SimpleResponseEntityManager();
    }

}
