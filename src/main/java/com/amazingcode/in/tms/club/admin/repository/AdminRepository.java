package com.amazingcode.in.tms.club.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazingcode.in.tms.club.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
