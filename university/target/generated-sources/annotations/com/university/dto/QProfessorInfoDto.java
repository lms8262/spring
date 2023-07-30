package com.university.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.university.dto.QProfessorInfoDto is a Querydsl Projection type for ProfessorInfoDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QProfessorInfoDto extends ConstructorExpression<ProfessorInfoDto> {

    private static final long serialVersionUID = -1360944092L;

    public QProfessorInfoDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<java.time.LocalDate> hireDate, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<java.time.LocalDate> birthDate, com.querydsl.core.types.Expression<String> gender, com.querydsl.core.types.Expression<String> tel, com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<String> address, com.querydsl.core.types.Expression<String> departmentName) {
        super(ProfessorInfoDto.class, new Class<?>[]{long.class, java.time.LocalDate.class, String.class, java.time.LocalDate.class, String.class, String.class, String.class, String.class, String.class}, id, hireDate, name, birthDate, gender, tel, email, address, departmentName);
    }

}

