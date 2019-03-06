/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.services.appuser;

import com.jmamoon.todolist.entities.appuser.AppUser;
import java.util.List;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 */
public interface AppUserService {

    public List<AppUser> findAll();

    public AppUser findById(Long id);

    public AppUser save(AppUser appUser);

    public void delete(AppUser appUser);
    
    public Long countAll();

}
