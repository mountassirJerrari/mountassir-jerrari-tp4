package org.example.eventservice.DTOs;

import lombok.*;
import org.example.eventservice.entities.enums.ConferenceType;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateConferenceDTO {

    private String title;
    private ConferenceType type;
    private Date date;
    private Long timeSpan;
    private Long registrationCount;
    private Long score;
}
