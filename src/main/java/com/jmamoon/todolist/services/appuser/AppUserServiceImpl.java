/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.services.appuser;

import com.jmamoon.todolist.entities.appuser.AppUser;
import com.jmamoon.todolist.exceptions.ResourceNotFoundException;
import com.jmamoon.todolist.resources.appuser.AppUserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserDao appUserDao;

    @Override
    @Transactional(readOnly = true)
    public List<AppUser> findAll() {
        return (List<AppUser>) this.appUserDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AppUser findById(Long id) throws RuntimeException {
        return this.appUserDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Error getting user."));
    }

    @Override
    @Transactional
    public AppUser save(AppUser appUser) {
        return this.appUserDao.save(appUser);
    }

    @Override
    @Transactional
    public void delete(AppUser appUser) {
        this.appUserDao.delete(appUser);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countAll() {
        return this.appUserDao.count();
    }
}
