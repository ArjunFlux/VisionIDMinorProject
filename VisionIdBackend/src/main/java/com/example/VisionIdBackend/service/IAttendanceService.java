package com.example.VisionIdBackend.service;

import com.example.VisionIdBackend.dto.ai.AIRequestDto;
import com.example.VisionIdBackend.entity.StudentEntity;

import java.util.List;

public interface IAttendanceService {


    List<StudentEntity> processAIAttendance(AIRequestDto request, String teacherEmail);
}
