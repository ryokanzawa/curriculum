package com.cmind.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmind.entity.Staff;


@Repository
public interface StaffRepository extends JpaRepository<Staff, String>{
	
	List<Staff> findByEmployeeId(String employeeId);
	List<Staff> findByEmployeeIdAndPassword(String employeeId, String password);
}