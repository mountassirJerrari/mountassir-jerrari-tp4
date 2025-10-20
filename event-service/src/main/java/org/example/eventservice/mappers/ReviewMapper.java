package org.example.eventservice.mappers;


import org.example.eventservice.DTOs.CreateReviewDTO;
import org.example.eventservice.DTOs.ReviewRequestDTO;
import org.example.eventservice.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    @Mapping(target = "conference" , ignore = true)
    Review toReview(CreateReviewDTO crd);
    @Mapping(target = "conference" , ignore = true)

    Review toReview(ReviewRequestDTO crd);


}
