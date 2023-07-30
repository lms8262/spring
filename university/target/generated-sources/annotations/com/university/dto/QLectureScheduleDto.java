package com.university.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.university.dto.QLectureScheduleDto is a Querydsl Projection type for LectureScheduleDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QLectureScheduleDto extends ConstructorExpression<LectureScheduleDto> {

    private static final long serialVersionUID = -1013456340L;

    public QLectureScheduleDto(com.querydsl.core.types.Expression<String> departmentName, com.querydsl.core.types.Expression<Long> lectureId, com.querydsl.core.types.Expression<String> type, com.querydsl.core.types.Expression<String> lectureName, com.querydsl.core.types.Expression<String> professorName, com.querydsl.core.types.Expression<Integer> credit, com.querydsl.core.types.Expression<String> day, com.querydsl.core.types.Expression<Integer> startTime, com.querydsl.core.types.Expression<Integer> endTime, com.querydsl.core.types.Expression<String> lectureRoomId, com.querydsl.core.types.Expression<Integer> numOfStudent, com.querydsl.core.types.Expression<Integer> capacity, com.querydsl.core.types.Expression<String> lectureCodeDetail) {
        super(LectureScheduleDto.class, new Class<?>[]{String.class, long.class, String.class, String.class, String.class, int.class, String.class, int.class, int.class, String.class, int.class, int.class, String.class}, departmentName, lectureId, type, lectureName, professorName, credit, day, startTime, endTime, lectureRoomId, numOfStudent, capacity, lectureCodeDetail);
    }

}

