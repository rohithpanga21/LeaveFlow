package com.leaveflow.leaveflow.repository;

import com.leaveflow.leaveflow.model.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveTypeRepo extends JpaRepository<LeaveType,Integer> {
}
