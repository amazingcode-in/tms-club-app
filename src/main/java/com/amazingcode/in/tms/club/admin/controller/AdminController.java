package com.amazingcode.in.tms.club.admin.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazingcode.in.tms.club.admin.entity.Admin;
import com.amazingcode.in.tms.club.admin.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/amazingcode.in.tms.club/admin")
public class AdminController {

    private static final Logger logger = Logger.getLogger(AdminController.class.getName());
    
    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        logger.info("Request recieved to create admin : "+admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addAdmin(admin));
    }

    @GetMapping("/login")
    public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin){
        logger.info("Request recieved to login admin : "+admin);
        return ResponseEntity.status(HttpStatus.FOUND).body(adminService.loginAdmin(admin));
    }
}
