package com.university.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.university.dto.QStudentInfoOfLectureDto is a Querydsl Projection type for StudentInfoOfLectureDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QStudentInfoOfLectureDto extends ConstructorExpression<StudentInfoOfLectureDto> {

    private static final long serialVersionUID = 1323518815L;

    public QStudentInfoOfLectureDto(com.querydsl.core.types.Expression<Long> studentId, com.querydsl.core.types.Expression<String> studentName, com.querydsl.core.types.Expression<String> departmentName, com.querydsl.core.types.Expression<String> grade) {
        super(StudentInfoOfLectureDto.class, new Class<?>[]{long.class, String.class, String.class, String.class}, studentId, studentName, departmentName, grade);
    }

    public QStudentInfoOfLectureDto(com.querydsl.core.types.Expression<Long> studentId, com.querydsl.core.types.Expression<String> studentName, com.querydsl.core.types.Expression<String> departmentName) {
        super(StudentInfoOfLectureDto.class, new Class<?>[]{long.class, String.class, String.class}, studentId, studentName, departmentName);
    }

}

