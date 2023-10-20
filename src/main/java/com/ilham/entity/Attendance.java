package com.ilham.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "check_in")
    private Date checkIn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "check_out")
    private Date checkOut;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
