package com.ilham.dto.response;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String position;
    private String createdAt;
    private String updatedAt;
}
