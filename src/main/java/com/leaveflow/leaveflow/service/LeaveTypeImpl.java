package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.dto.LeaveTypeRequestDto;
import com.leaveflow.leaveflow.dto.LeaveTypeResponseDto;
import com.leaveflow.leaveflow.exception.ResourceNotFoundException;
import com.leaveflow.leaveflow.model.LeaveType;
import com.leaveflow.leaveflow.repository.LeaveTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveTypeImpl implements LeaveTypeService {

    private final LeaveTypeRepo leaveTypeRepo;

    public LeaveTypeImpl(LeaveTypeRepo leaveTypeRepo) {
        this.leaveTypeRepo = leaveTypeRepo;
    }

    @Override
    public List<LeaveTypeResponseDto> getAllLeaveTypes() {
        return leaveTypeRepo.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public LeaveTypeResponseDto getLeaveTypeById(int id) {

        LeaveType leaveType = leaveTypeRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave Type not found with ID " + id));

        return mapToResponseDto(leaveType);
    }

    @Override
    public LeaveTypeResponseDto createLeaveType(LeaveTypeRequestDto dto) {

        LeaveType leaveType = new LeaveType();
        leaveType.setLeaveTypeId(dto.getLeaveTypeId());
        leaveType.setLeaveTypeName(dto.getLeaveTypeName());
        leaveType.setMaxDays(dto.getMaxDays());

        LeaveType savedLeaveType = leaveTypeRepo.save(leaveType);

        return mapToResponseDto(savedLeaveType);
    }

    @Override
    public LeaveTypeResponseDto updateLeaveType(int id, LeaveTypeRequestDto dto) {

        LeaveType existingLeaveType = leaveTypeRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave Type not found with ID " + id));

        existingLeaveType.setLeaveTypeName(dto.getLeaveTypeName());
        existingLeaveType.setMaxDays(dto.getMaxDays());

        LeaveType updatedLeaveType = leaveTypeRepo.save(existingLeaveType);

        return mapToResponseDto(updatedLeaveType);
    }

    @Override
    public void deleteLeaveTypeById(int id) {

        LeaveType leaveType = leaveTypeRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave Type not found with ID " + id));

        leaveTypeRepo.delete(leaveType);
    }

    private LeaveTypeResponseDto mapToResponseDto(LeaveType leaveType) {

        LeaveTypeResponseDto dto = new LeaveTypeResponseDto();

        dto.setLeaveTypeId(leaveType.getLeaveTypeId());
        dto.setLeaveTypeName(leaveType.getLeaveTypeName());
        dto.setMaxDays(leaveType.getMaxDays());

        return dto;
    }
}