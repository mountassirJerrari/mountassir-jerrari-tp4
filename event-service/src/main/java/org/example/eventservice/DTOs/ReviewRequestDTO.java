package org.example.eventservice.DTOs;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequestDTO {

    private Date date;
    private String feedback;
    private Long stars ;
    private Long conferenceId;
}
