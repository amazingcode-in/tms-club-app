package com.amazingcode.in.tms.club.admin.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazingcode.in.tms.club.admin.entity.Admin;
import com.amazingcode.in.tms.club.admin.service.AdminService;

@RestController
@RequestMapping("api/amazingcode.in.tms.club/admin")
public class AdminController {

    private static final Logger logger = Logger.getLogger(AdminController.class.getName());
    
    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(Admin admin){
        logger.info("Request recieved to create admin : "+admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addAdmin(admin));
    }
}
