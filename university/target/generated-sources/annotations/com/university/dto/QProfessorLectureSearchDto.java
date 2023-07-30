package com.university.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.university.dto.QProfessorLectureSearchDto is a Querydsl Projection type for ProfessorLectureSearchDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QProfessorLectureSearchDto extends ConstructorExpression<ProfessorLectureSearchDto> {

    private static final long serialVersionUID = 164053702L;

    public QProfessorLectureSearchDto(com.querydsl.core.types.Expression<Integer> year, com.querydsl.core.types.Expression<Integer> semester) {
        super(ProfessorLectureSearchDto.class, new Class<?>[]{int.class, int.class}, year, semester);
    }

}

