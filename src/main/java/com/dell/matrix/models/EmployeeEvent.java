package com.dell.matrix.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "employee_events")
@SequenceGenerator(name = "seq", initialValue = 1)
public class EmployeeEvent {

    @Id
    @GeneratedValue(generator = "seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_badge")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "checkin_date")
    private LocalDateTime checkinDate;
}
