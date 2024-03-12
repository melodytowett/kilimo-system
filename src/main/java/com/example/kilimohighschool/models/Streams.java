package com.example.kilimohighschool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Streams {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String streamName;
    @OneToMany(mappedBy = "streams", cascade = CascadeType.ALL)
    private List<Students> students;
}
