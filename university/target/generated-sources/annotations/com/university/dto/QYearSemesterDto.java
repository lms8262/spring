package com.university.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.university.dto.QYearSemesterDto is a Querydsl Projection type for YearSemesterDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QYearSemesterDto extends ConstructorExpression<YearSemesterDto> {

    private static final long serialVersionUID = 1511718280L;

    public QYearSemesterDto(com.querydsl.core.types.Expression<Integer> year, com.querydsl.core.types.Expression<Integer> semester) {
        super(YearSemesterDto.class, new Class<?>[]{int.class, int.class}, year, semester);
    }

}

