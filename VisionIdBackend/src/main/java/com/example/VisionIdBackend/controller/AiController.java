package com.example.VisionIdBackend.controller;


import com.example.VisionIdBackend.dto.ResponseDto;
import com.example.VisionIdBackend.dto.ai.AIRequestDto;
import com.example.VisionIdBackend.entity.AttendanceEntity;
import com.example.VisionIdBackend.entity.StudentEntity;
import com.example.VisionIdBackend.service.IAttendanceService;
import com.example.VisionIdBackend.service.IJwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AiController {


    @Autowired
    private IJwtService jwtService;

    @Autowired
    private IAttendanceService attendanceService;

    @PostMapping("/attendance/ai-upload")
    public ResponseEntity<List<StudentEntity>> uploadAttendance(
            @RequestBody AIRequestDto aiRequestDto
    ) {
        String teacherUid = aiRequestDto.getTeacherUid();
        List<StudentEntity> students = attendanceService.processAIAttendance(aiRequestDto, teacherUid);
        return ResponseEntity.ok(students);
    }
}
