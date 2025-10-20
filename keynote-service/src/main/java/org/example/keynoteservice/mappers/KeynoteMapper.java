package org.example.keynoteservice.mappers;

import org.example.keynoteservice.DTOs.KeynoteRequestDTO;
import org.example.keynoteservice.entities.Keynote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KeynoteMapper {

     Keynote toKeynote(KeynoteRequestDTO keynoteRequestDTO);
}
