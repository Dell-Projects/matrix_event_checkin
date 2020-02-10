package com.dell.matrix.Models.Transition;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class CheckInRequest {
    private Long employeeBadge;
    private Long eventId;
}
