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
        @RequestBody AIRequestDto aiRequestDto,
        @RequestHeader(value = "Authorization", required = false) String authHeader
) {
    String teacherUid = null;
    
    // Only extract token if authHeader exists
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
        String token = authHeader.substring(7);
        teacherUid = jwtService.extractUid(token);
    }

    // Use teacherUid from payload if not from token
    if (teacherUid == null || teacherUid.isBlank()) {
        teacherUid = aiRequestDto.getTeacherUid();
    }

    List<StudentEntity> students = attendanceService.processAIAttendance(aiRequestDto, teacherUid);
    return ResponseEntity.ok(students);
}
}
