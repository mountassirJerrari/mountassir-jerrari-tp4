package org.example.eventservice.DTOs;

import lombok.Data;


@Data
public class CreateReviewDTO {

    private String feedback;


    private Long stars;

    private Long conferenceId;
}