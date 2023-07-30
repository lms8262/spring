package com.university.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.university.dto.QProfessorLectureDto is a Querydsl Projection type for ProfessorLectureDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QProfessorLectureDto extends ConstructorExpression<ProfessorLectureDto> {

    private static final long serialVersionUID = -286650162L;

    public QProfessorLectureDto(com.querydsl.core.types.Expression<Long> lectureId, com.querydsl.core.types.Expression<String> lectureCodeDetail, com.querydsl.core.types.Expression<String> type, com.querydsl.core.types.Expression<String> lectureName, com.querydsl.core.types.Expression<Integer> credit, com.querydsl.core.types.Expression<String> day, com.querydsl.core.types.Expression<Integer> startTime, com.querydsl.core.types.Expression<Integer> endTime, com.querydsl.core.types.Expression<String> lectureRoomId, com.querydsl.core.types.Expression<Integer> numOfStudent, com.querydsl.core.types.Expression<Integer> capacity) {
        super(ProfessorLectureDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, int.class, String.class, int.class, int.class, String.class, int.class, int.class}, lectureId, lectureCodeDetail, type, lectureName, credit, day, startTime, endTime, lectureRoomId, numOfStudent, capacity);
    }

    public QProfessorLectureDto(com.querydsl.core.types.Expression<Long> lectureId, com.querydsl.core.types.Expression<String> lectureCodeDetail, com.querydsl.core.types.Expression<String> type, com.querydsl.core.types.Expression<String> lectureName, com.querydsl.core.types.Expression<Integer> credit, com.querydsl.core.types.Expression<Integer> year, com.querydsl.core.types.Expression<Integer> semester, com.querydsl.core.types.Expression<String> day, com.querydsl.core.types.Expression<Integer> startTime, com.querydsl.core.types.Expression<Integer> endTime, com.querydsl.core.types.Expression<String> lectureRoomId, com.querydsl.core.types.Expression<Integer> numOfStudent, com.querydsl.core.types.Expression<Integer> capacity) {
        super(ProfessorLectureDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, int.class, int.class, int.class, String.class, int.class, int.class, String.class, int.class, int.class}, lectureId, lectureCodeDetail, type, lectureName, credit, year, semester, day, startTime, endTime, lectureRoomId, numOfStudent, capacity);
    }

}

