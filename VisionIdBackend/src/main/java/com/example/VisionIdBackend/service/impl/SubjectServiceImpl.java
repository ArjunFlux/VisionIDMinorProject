package com.example.VisionIdBackend.service.impl;

import com.example.VisionIdBackend.dto.SubjectDTO;
import com.example.VisionIdBackend.entity.SubjectEntity;
import com.example.VisionIdBackend.entity.TeacherEntity;
import com.example.VisionIdBackend.exception.ClassAlreadyExistsException;
import com.example.VisionIdBackend.exception.ResourceNotFoundException;
import com.example.VisionIdBackend.repository.SubjectRepository;
import com.example.VisionIdBackend.repository.TeacherRepository;
import com.example.VisionIdBackend.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubjectServiceImpl implements ISubjectService {


    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;



    @Override
    public void addSubject(SubjectDTO dto, String uid) {

        TeacherEntity teacher = teacherRepository.findByUid(uid);

        if(teacher == null){
            throw new  ResourceNotFoundException("Teacher not found");
        }

        // Reuse if exists, create if not
        SubjectEntity subject = subjectRepository.findById(dto.getCode())
                .orElseGet(() -> {
                    SubjectEntity newSubject = new SubjectEntity();
                    newSubject.setCode(dto.getCode());
                    newSubject.setSubjectName(dto.getSubjectName());
                    return subjectRepository.save(newSubject);
                });

        // Only check if THIS teacher already has it
        if (teacher.getSubjects().contains(subject)) {
            throw new RuntimeException("You have already added this subject");
        }

        teacher.getSubjects().add(subject);
        teacherRepository.save(teacher);
    }

    @Override
    public List<SubjectEntity> getAllSubjects() {

        List<SubjectEntity> subjects = subjectRepository.findAll();

        if(subjects.isEmpty()){
            throw new  ResourceNotFoundException("You have not added subjects ");
        }

        return subjects;

    }
}
