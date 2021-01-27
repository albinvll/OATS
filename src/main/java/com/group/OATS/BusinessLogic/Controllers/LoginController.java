package com.group.OATS.BusinessLogic.Controllers;

import com.group.OATS.DataAccess.Services.LoginServices;
import com.group.OATS.Models.Perdoruesi;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/login")
public class LoginController {
    private LoginServices loginServices;
    public LoginController(LoginServices loginServices){
        this.loginServices = loginServices;
    }

    @PostMapping
    @Transactional
    @RequestMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody Perdoruesi perdoruesi){
        try{
            loginServices.insertPerdoruesin(perdoruesi);
            return ResponseEntity.ok("Ok");
        }catch (Exception e){
            e.printStackTrace();
            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
    }

    @PostMapping
    @Transactional
    public Perdoruesi login(@RequestBody Perdoruesi perdoruesi){
        try{
            return loginServices.getPerdoruesinPerLogin(perdoruesi);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
