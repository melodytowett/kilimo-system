package com.example.kilimohighschool.services;

import com.example.kilimohighschool.models.Dto.StudentsDto;
import com.example.kilimohighschool.models.Students;

import java.util.List;

public interface StudentsService {
    StudentsDto addStudents (StudentsDto studentsDto,Long streamsId);
    List<StudentsDto>getById(Long id);
    List<Students>getAllStudents();
    StudentsDto updateStudent(Long id,StudentsDto studentsDto);
    void deleteStudent(Long id);
    List<StudentsDto>getByStreamId(Long streamsId);
}
