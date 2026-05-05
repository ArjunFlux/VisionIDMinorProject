package com.example.VisionIdBackend.dto.ai;


import com.example.VisionIdBackend.dto.SubjectDTO;
import jakarta.persistence.Column;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class AIRequestDto {

    @Column(nullable = false)
    private String subjectCode;

    @Column(nullable = false)
    private String batchCode; //23A11

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private List<String> recognizedStudents;
}



/*
{
  "batchCode": 23A11,
  "date": "2026-02-23",
  "recognizedStudents": [
    "231030286",
    "-----596",
    "-----111"
  ]
}
*/

//Yah  hai json response
//{
//        "batchCode": "23A11",
//        "className": "Computer Vision",
//        "classTime": "2026-05-04 21:28:56",
//        "students": [
//        {
//        "roll_number": "231030319",
//        "name": "Parth Upadhyay"
//        },
//        {
//        "roll_number": "231030280",
//        "name": "Sumeet Singh"
//        }
//        ]
//        }