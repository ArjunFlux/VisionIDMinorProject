package com.example.VisionIdBackend.service;

import com.example.VisionIdBackend.dto.SubjectDTO;
import com.example.VisionIdBackend.entity.SubjectEntity;

public interface ISubjectService {

    void addSubject(SubjectDTO dto,String uid);

}
