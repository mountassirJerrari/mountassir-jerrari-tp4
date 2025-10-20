package org.example.keynoteservice.controllers;


import jakarta.servlet.http.HttpServletResponse;
import org.example.keynoteservice.DTOs.KeynoteRequestDTO;
import org.example.keynoteservice.entities.Keynote;
import org.example.keynoteservice.mappers.KeynoteMapper;
import org.example.keynoteservice.services.KeynoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keynotes")
public class KeynoteController {

    @Autowired
    private KeynoteService keynoteService;

    @Autowired
    private  KeynoteMapper keynoteMapper;

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

   @PostMapping()
    public Keynote insertKeynote( @RequestBody KeynoteRequestDTO keynoteRequestDTO ){


        return keynoteService.createKeynote(keynoteMapper.toKeynote(keynoteRequestDTO));

   }

   @PutMapping("/{id}")
    public Keynote updateKeynote(@PathVariable Long id  , @RequestBody KeynoteRequestDTO knDTO , HttpServletResponse response){

        var keynote = keynoteService.updateKeynote(id,keynoteMapper.toKeynote(knDTO));

       if(keynote.isEmpty()) {
           response.setStatus(HttpServletResponse.SC_NOT_FOUND);
       }
       return keynote.get();

   }

   @DeleteMapping("/{id}")
    public boolean deleteKeynote ( @PathVariable Long id){

         keynoteService.deleteKeynote(id);
         return true ;
   }


}
