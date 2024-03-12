package com.example.kilimohighschool.services;

import com.example.kilimohighschool.models.Dto.StreamsDto;
import com.example.kilimohighschool.models.Streams;

import java.util.List;

public interface StreamsService {
    StreamsDto captureStream (StreamsDto streamsDto);
    List<Streams> getAll();
    List<StreamsDto> getById(Long id);
}
