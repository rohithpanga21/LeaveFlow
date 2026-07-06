package com.leaveflow.leaveflow.controller;

import com.leaveflow.leaveflow.dto.RoleRequestDto;
import com.leaveflow.leaveflow.dto.RoleResponseDto;
import com.leaveflow.leaveflow.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(
            @Valid @RequestBody RoleRequestDto roleRequestDto) {

        return new ResponseEntity<>(
                service.createRole(roleRequestDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getAllRoles() {
        return ResponseEntity.ok(service.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDto> getRoleById(@PathVariable int id) {
        return ResponseEntity.ok(service.getRoleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDto> updateRole(
            @PathVariable int id,
            @Valid @RequestBody RoleRequestDto roleRequestDto) {

        return ResponseEntity.ok(service.updateRole(id, roleRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable int id) {

        service.deleteRoleById(id);

        return ResponseEntity.ok("Role Deleted Successfully");
    }
}