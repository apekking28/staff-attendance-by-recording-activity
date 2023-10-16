package com.ilham.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequest {
    private String name;
    private String username;
    private String email;
    private String address;
    private String position;
}
