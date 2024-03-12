package com.example.kilimohighschool.controllers;

import com.example.kilimohighschool.models.Dto.StudentsDto;
import com.example.kilimohighschool.services.StudentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping("/{streamsId}/capture")
    public ResponseEntity<StudentsDto> captureStudents(@PathVariable Long streamsId, @RequestBody StudentsDto studentsDto){
        return new ResponseEntity<>(studentsService.addStudents(studentsDto,streamsId), HttpStatus.CREATED);
    }
    @GetMapping("/all-students")
    public ResponseEntity<?>viewAllStudents(){
        return new ResponseEntity<>(studentsService.getAllStudents(),HttpStatus.OK);
    }

    @GetMapping("/single-student/{id}")
    public List<StudentsDto>getOneStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentsService.getById(id),HttpStatus.OK).getBody();
    }
    @GetMapping("/students/stream/{streamsId}")
    public List<StudentsDto>getStudentsBelongingToAStream(@PathVariable Long streamsId){
        return studentsService.getByStreamId(streamsId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentsDto> updateStudent(@PathVariable Long id, StudentsDto studentsDto){
        StudentsDto updateStudent = studentsService.updateStudent(id,studentsDto);
        return new ResponseEntity<>(updateStudent,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteStudent(@PathVariable Long id){
        studentsService.deleteStudent(id);
        return new ResponseEntity<>("User has be deleted",HttpStatus.OK);
    }
}
