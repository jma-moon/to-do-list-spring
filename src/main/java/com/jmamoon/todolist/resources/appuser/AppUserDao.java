/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.resources.appuser;

import com.jmamoon.todolist.entities.appuser.AppUser;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 */
public interface AppUserDao extends CrudRepository<AppUser, Long> {

}
