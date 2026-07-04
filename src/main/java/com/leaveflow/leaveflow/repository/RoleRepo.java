package com.leaveflow.leaveflow.repository;

import com.leaveflow.leaveflow.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {

}
