package org.example.eventservice.mappers;

import org.example.eventservice.DTOs.CreateConferenceDTO;
import org.example.eventservice.entities.Conference;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConferenceMapper {

    Conference toConference(CreateConferenceDTO ccd);

}
