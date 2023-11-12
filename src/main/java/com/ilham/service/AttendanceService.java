package com.ilham.service;

import com.ilham.dto.request.AttendanceRequestDTO;
import com.ilham.dto.response.AttendanceResponseDTO;
import org.springframework.stereotype.Service;


public interface AttendanceService {
     AttendanceResponseDTO checkIn(Long employeeId);
     AttendanceResponseDTO checkOut(Long employeeId ,Long AttendanceId);

     
}
