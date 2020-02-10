package com.dell.matrix.models.Transition;

import lombok.*;

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
