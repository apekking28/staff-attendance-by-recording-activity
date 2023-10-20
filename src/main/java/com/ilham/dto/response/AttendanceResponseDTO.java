package com.ilham.dto.response;

import com.ilham.entity.Employee;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceResponseDTO {
    private Long id;
    private String status;
    private String checkInDate;
    private String checkInHour;
    private String checkOutDate;
    private String checkOutHour;
    private Employee employee;
}
