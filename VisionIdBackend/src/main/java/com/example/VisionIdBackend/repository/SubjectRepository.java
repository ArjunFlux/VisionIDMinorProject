package com.example.VisionIdBackend.repository;

import com.example.VisionIdBackend.entity.StudentEntity;
import com.example.VisionIdBackend.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<SubjectEntity,String> {

    Optional<SubjectEntity> findByCode(String code);
}
