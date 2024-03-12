package com.example.kilimohighschool.services.serviceImpl;

import com.example.kilimohighschool.models.Dto.StudentsDto;
import com.example.kilimohighschool.models.Streams;
import com.example.kilimohighschool.models.Students;
import com.example.kilimohighschool.repositories.StreamsRepo;
import com.example.kilimohighschool.repositories.StudentsRepo;
import com.example.kilimohighschool.services.StudentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsServiceImpl  implements StudentsService {
    private final StudentsRepo repo;
    private final StreamsRepo streamsRepo;

    public StudentsServiceImpl(StudentsRepo repo, StreamsRepo streamsRepo) {
        this.repo = repo;
        this.streamsRepo = streamsRepo;
    }

    @Override
    public StudentsDto addStudents(StudentsDto studentsDto, Long streamsId) {
        Students students =  mapToEntity(studentsDto);
        Streams streams = streamsRepo.findById(streamsId).orElseThrow(()->new RuntimeException("that form is not present"));
        students.setStreams(streams);
        students.setId(students.getId());
        students.setStudentName(students.getStudentName());
        students.setStudentAdmission(students.getStudentAdmission());
        Students neeStudent = repo.save(students);
        return mapToDto(neeStudent);
    }

    @Override
    public List<StudentsDto> getById(Long id) {
        Optional<Students> students = repo.findById(id);
        return students.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<Students> getAllStudents() {
        List<Students> students = repo.findAll();
        return students;
    }

    @Override
    public StudentsDto updateStudent(Long id, StudentsDto studentsDto) {
        Students students = repo.findById(id).orElseThrow(()->new RuntimeException("that student is not found"));
        students.setStudentName(studentsDto.getStudentName());
        students.setStudentAdmission(studentsDto.getStudentAdmission());
        Students updatedStudent = repo.save(students);
        return mapToDto(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<StudentsDto> getByStreamId(Long streamsId) {
        List<Students> studentsList = repo.findByStreamsId(streamsId);
        return studentsList.stream().map(this::mapToDto).toList();
    }

    private StudentsDto mapToDto(Students students){
        StudentsDto studentsDto = new StudentsDto();
        studentsDto.setId(students.getId());
        studentsDto.setStudentName(students.getStudentName());
        studentsDto.setStudentAdmission(students.getStudentAdmission());
        return studentsDto;
    }

    private Students mapToEntity(StudentsDto studentsDto){
        Students students = new Students();
        students.setId(studentsDto.getId());
        students.setStudentName(studentsDto.getStudentName());
        students.setStudentAdmission(studentsDto.getStudentAdmission());
        return students;
    }
}
