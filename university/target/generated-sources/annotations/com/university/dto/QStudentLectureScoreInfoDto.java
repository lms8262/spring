package com.university.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.university.dto.QStudentLectureScoreInfoDto is a Querydsl Projection type for StudentLectureScoreInfoDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QStudentLectureScoreInfoDto extends ConstructorExpression<StudentLectureScoreInfoDto> {

    private static final long serialVersionUID = -1668532604L;

    public QStudentLectureScoreInfoDto(com.querydsl.core.types.Expression<Integer> year, com.querydsl.core.types.Expression<Integer> semester, com.querydsl.core.types.Expression<String> lectureCodeDetail, com.querydsl.core.types.Expression<Long> lectureId, com.querydsl.core.types.Expression<String> lectureName, com.querydsl.core.types.Expression<String> type, com.querydsl.core.types.Expression<String> professorName, com.querydsl.core.types.Expression<Integer> credit, com.querydsl.core.types.Expression<String> grade) {
        super(StudentLectureScoreInfoDto.class, new Class<?>[]{int.class, int.class, String.class, long.class, String.class, String.class, String.class, int.class, String.class}, year, semester, lectureCodeDetail, lectureId, lectureName, type, professorName, credit, grade);
    }

}

