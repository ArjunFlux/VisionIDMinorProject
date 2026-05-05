package com.example.VisionIdBackend.controller;


import com.example.VisionIdBackend.dto.ResponseDto;
import com.example.VisionIdBackend.dto.SubjectDTO;
import com.example.VisionIdBackend.dto.TeacherDto;
import com.example.VisionIdBackend.dto.loginDtos.LoginRequestDto;
import com.example.VisionIdBackend.dto.loginDtos.LoginResponseDto;
import com.example.VisionIdBackend.entity.SubjectEntity;
import com.example.VisionIdBackend.service.IJwtService;
import com.example.VisionIdBackend.service.ISubjectService;
import com.example.VisionIdBackend.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TeacherController {

    @Autowired
    private ITeacherService service;

    @Autowired
    private IJwtService jwtService;

    @Autowired
    private ISubjectService subjectService;

    @PostMapping("/registerTeacher")
    public ResponseEntity<ResponseDto> registerTeacher(@RequestBody TeacherDto dto) {

        service.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201", "Faculty registered successfully"));

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto) {
        String response =  service.login(dto);

        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDto(response));

    }


    @PostMapping("/addSubject")
    public ResponseEntity<String> addSubject(
            @RequestBody SubjectDTO dto,
            @RequestHeader("Authorization") String authHeader) {

        String token = authHeader.substring(7); // removes "Bearer "
        String uid = jwtService.extractUid(token);

        subjectService.addSubject(dto, uid);
        return ResponseEntity.ok("Subject added successfully");
    }

}
