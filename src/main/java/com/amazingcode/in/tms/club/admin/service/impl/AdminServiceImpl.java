package com.amazingcode.in.tms.club.admin.service.impl;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.amazingcode.in.tms.club.admin.entity.Admin;
import com.amazingcode.in.tms.club.admin.repository.AdminRepository;
import com.amazingcode.in.tms.club.admin.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger logger = Logger.getLogger(AdminServiceImpl.class.getName());
    
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin addAdmin(Admin admin) {
        logger.info("Request recieved to create admin : "+admin);
        return adminRepository.save(admin);
    }

    @Override
    public Admin loginAdmin(Admin admin) {
        logger.info("Request recieved to login admin : "+admin);
        return adminRepository.findByEmailAddressAndPassword(admin.getEmailAddress(), admin.getPassword());
    }
}
