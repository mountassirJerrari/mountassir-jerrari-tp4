package org.example.keynoteservice.controllers;


import jakarta.servlet.http.HttpServletResponse;
import org.example.keynoteservice.DTOs.KeynoteRequestDTO;
import org.example.keynoteservice.entities.Keynote;
import org.example.keynoteservice.services.KeynoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keynotes")
public class KeynoteController {

    @Autowired
    private KeynoteService keynoteService;

    @GetMapping
    public List<Keynote> getAllKeynotes() {
        return keynoteService.getAllKeynotes();
    }
    @GetMapping("/{id}")
    public Keynote getKeynote(@PathVariable Long id , HttpServletResponse response) {
        var keynote =  keynoteService.getKeynoteById(id);
        if(keynote.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return keynote.get();
    }

   @PostMapping("/{id}")
    public Keynote insertKeynote(@PathVariable Long id , @RequestBody KeynoteRequestDTO keynoteRequestDTO ){


        Keynote keynote = keynoteService.createKeynote(keynoteRequestDTO);
   }


}
