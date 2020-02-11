package com.dell.matrix.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "events")
@SequenceGenerator(name = "seq_event", initialValue = 1, allocationSize = 1)
public class Event {

    @Id
    @GeneratedValue(generator = "seq_event")
    private Long id;

    private String name;

    private String description;

    private Integer capacity;

    private String eventTarget;

    private String location;

    private LocalDateTime date;

    @Column(name = "final_date")
    private LocalDateTime finalDate;

    @Column(name = "has_gift")
    private Boolean hasGift;

    @JsonIgnore
    @OneToMany(mappedBy = "event")
    private Set<EmployeeEvent> employeeEvents = new HashSet<>();

}
