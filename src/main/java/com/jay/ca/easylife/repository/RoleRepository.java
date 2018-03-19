package com.jay.ca.easylife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jay.ca.easylife.model.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role,Integer>{
		Role findByRole(String role);
}
