package org.example.eventservice.controllers;


import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.eventservice.DTOs.CreateConferenceDTO;
import org.example.eventservice.Services.ConferenceService;
import org.example.eventservice.entities.Conference;
import org.example.eventservice.mappers.ConferenceMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
@RequiredArgsConstructor
public class ConferenceController {

    private final ConferenceService conferenceService ;
    private final ConferenceMapper conferenceMapper;

    @GetMapping
    List<Conference> getAll(){
        return conferenceService.getAll();
    }
    @PostMapping
    Conference addConference(@RequestBody CreateConferenceDTO ccd , HttpServletResponse res){

       var conference =  conferenceService.insert(conferenceMapper.toConference(ccd));
        if (conference.isEmpty())
        {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }
        return conference.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void Conference(@PathVariable Long id){

        conferenceService.deleteById(id);


    }

    @GetMapping("/{id}")
    public Conference Conference(@PathVariable Long id,HttpServletResponse res){

        var conference =  conferenceService.getById(id);
        if (conference.isEmpty())
        {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }
        return conference.orElse(null);



    }




}
