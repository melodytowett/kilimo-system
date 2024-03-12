package com.example.kilimohighschool.services.serviceImpl;

import com.example.kilimohighschool.models.Dto.StreamsDto;
import com.example.kilimohighschool.models.Streams;
import com.example.kilimohighschool.repositories.StreamsRepo;
import com.example.kilimohighschool.services.StreamsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StreamsServiceImpl implements StreamsService {
    private final StreamsRepo streamsRepo;

    public StreamsServiceImpl(StreamsRepo streamsRepo) {
        this.streamsRepo = streamsRepo;
    }
    @Override
    public StreamsDto captureStream (StreamsDto streamsDto){
        Streams streams = mapToEntity(streamsDto);
        streams.setId(streamsDto.getId());
        streams.setStreamName(streamsDto.getStreamName());
        Streams streams1 = streamsRepo.save(streams);
        return matToDto(streams1);
    }

    @Override
    public List<Streams> getAll() {
        List<Streams> streams = streamsRepo.findAll();
        return streams;
    }

    @Override
    public List<StreamsDto> getById(Long id) {
        Optional<Streams> streams = streamsRepo.findById(id);
        return streams.stream().map(this::matToDto).collect(Collectors.toList());
    }


    private StreamsDto matToDto(Streams streams){
        StreamsDto streamsDto = new StreamsDto();
        streamsDto.setId(streams.getId());
        streamsDto.setStreamName(streams.getStreamName());
        return streamsDto;
    }
    private Streams mapToEntity(StreamsDto streamsDto){
        Streams streams =  new Streams();
        streams.setId(streamsDto.getId());
        streams.setStreamName(streamsDto.getStreamName());
        return streams;
    }
}
