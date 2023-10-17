package com.ilham.dto;

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

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt; // Field to track the creation date and time
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedAt; // to track the last update date and time
}
