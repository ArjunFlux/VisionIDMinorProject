package com.example.VisionIdBackend.controller;


import com.example.VisionIdBackend.dto.SubjectDTO;
import com.example.VisionIdBackend.entity.SubjectEntity;
import com.example.VisionIdBackend.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AttendanceController {


    @Autowired
    private ISubjectService subjectService;

    @GetMapping("/getall-subjects")
    public ResponseEntity<List<SubjectEntity>> getAllSubjects(){


        List<SubjectEntity> subjects = subjectService.getAllSubjects();
        return ResponseEntity.status(HttpStatus.OK).body(subjects);

    }



//    @GetMapping("/get-attendance-per-allstudents/{subject}")
//    public ResponseEntity<String> getAttendance(@PathVariable String subjectName) {
//
//
//    }







}
