package com.example.VisionIdBackend.service;

import com.example.VisionIdBackend.dto.SubjectDTO;
import com.example.VisionIdBackend.entity.SubjectEntity;

import java.util.List;

public interface ISubjectService {

    void addSubject(SubjectDTO dto,String uid);


    List<SubjectEntity> getAllSubjects();

}
