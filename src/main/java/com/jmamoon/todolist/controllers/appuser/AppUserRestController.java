/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmamoon.todolist.controllers.appuser;

import com.jmamoon.todolist.entities.appuser.AppUser;
import com.jmamoon.todolist.helpers.errorhandler.ErrorHandler;
import com.jmamoon.todolist.helpers.errorhandler.ErrorHandlerFactory;
import com.jmamoon.todolist.helpers.responseentitymanager.ResponseEntityManager;
import com.jmamoon.todolist.helpers.responseentitymanager.ResponseEntityManagerFactory;
import com.jmamoon.todolist.services.appuser.AppUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jose Arandia Luna https://github.com/jma-moon
 */
@RestController
@RequestMapping("/api")
public class AppUserRestController {

    @Autowired
    private AppUserService appUserService;

    private final ResponseEntityManager responseEntitymanager = ResponseEntityManagerFactory.create();
    private final ErrorHandler errorhandler = ErrorHandlerFactory.create();

    @GetMapping("/users")
    public ResponseEntity index() {

        ResponseEntity response;

        try {
            List<AppUser> appUserList = this.appUserService.findAll();
            Long total = this.appUserService.countAll();
            HttpStatus httpStatus = HttpStatus.OK;

            response = this.responseEntitymanager.createMultipleResponse(httpStatus, appUserList, total);
        } catch (Exception e) {

            response = this.errorhandler.getError(e);
        }

        return response;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") Long id) {

        ResponseEntity response;

        try {
            AppUser appUser = this.appUserService.findById(id);
            HttpStatus httpStatus = HttpStatus.OK;

            response = this.responseEntitymanager.createSingleResponse(httpStatus, appUser);
        } catch (Exception e) {

            response = this.errorhandler.getError(e);
        }

        return response;
    }

    @PostMapping("/users")
    public ResponseEntity create(@RequestBody AppUser appUser) {

        ResponseEntity response;

        try {

            AppUser savedAppUser = this.appUserService.save(appUser);
            HttpStatus httpStatus = HttpStatus.CREATED;

            response = this.responseEntitymanager.createSingleResponse(httpStatus, savedAppUser);
        } catch (Exception e) {

            response = this.errorhandler.getError(e);
        }

        return response;
    }

    @PutMapping("/users/{id}")
    public ResponseEntity update(@RequestBody AppUser appUser, @PathVariable(name = "id") Long id) {

        ResponseEntity response;

        try {

            AppUser current = this.appUserService.findById(id);

            current.setFirstName(appUser.getFirstName());
            current.setLastName(appUser.getLastName());
            current.setUserName(appUser.getUserName());
            current.setPassword(appUser.getPassword());

            current = this.appUserService.save(current);

            HttpStatus httpStatus = HttpStatus.CREATED;

            response = this.responseEntitymanager.createSingleResponse(httpStatus, current);
        } catch (Exception e) {

            response = this.errorhandler.getError(e);
        }

        return response;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") Long id) {

        ResponseEntity response;

        try {

            AppUser current = this.appUserService.findById(id);

            this.appUserService.delete(current);

            HttpStatus httpStatus = HttpStatus.OK;

            response = this.responseEntitymanager.createSingleResponse(httpStatus, current);
        } catch (Exception e) {

            response = this.errorhandler.getError(e);
        }

        return response;
    }
}
