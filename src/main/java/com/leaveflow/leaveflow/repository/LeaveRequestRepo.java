package com.leaveflow.leaveflow.repository;

import com.leaveflow.leaveflow.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestRepo extends JpaRepository<LeaveRequest,Integer> {

}
