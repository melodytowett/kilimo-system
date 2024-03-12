package com.example.kilimohighschool.controllers;

import com.example.kilimohighschool.models.Dto.StreamsDto;
import com.example.kilimohighschool.services.StreamsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/streams")
public class StreamsControllers {
    private final StreamsService streamsService;

    public StreamsControllers(StreamsService streamsService) {
        this.streamsService = streamsService;
    }

    @PostMapping("/capture")
    public ResponseEntity<StreamsDto>captureStreams(@RequestBody StreamsDto streamsDto){
        return new ResponseEntity<>(streamsService.captureStream(streamsDto), HttpStatus.CREATED);
    }
    @GetMapping("/view-all")
    public ResponseEntity<?>viewAllStreams (){
        return new ResponseEntity<>(streamsService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/view-single/{id}")
    public List<StreamsDto> egtByStreamId(@PathVariable Long id){
        return new ResponseEntity<>(streamsService.getById(id),HttpStatus.OK).getBody();
    }
}
