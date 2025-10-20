package org.example.eventservice.entities;


import jakarta.persistence.*;
import lombok.*;
import org.example.eventservice.entities.enums.ConferenceType;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Enumerated( EnumType.STRING)
    private ConferenceType type;
    private Date date;
    private Long timeSpan;
    private Long registrationCount;
    private Long score;

    @OneToMany(mappedBy = "conference")
    private List<Review> reviews ;
}
