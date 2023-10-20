package com.ilham.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequestDTO {
    private String name;
    private String username;
    private String email;
    private String address;
    private String position;
}
