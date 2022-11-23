package com.cmind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmind.entity.Staff;


@Repository
public interface StaffRepository extends JpaRepository<Staff, String>{
	
	Staff findByEmployeeIdAndPassword(String employeeId, String password);
	
}