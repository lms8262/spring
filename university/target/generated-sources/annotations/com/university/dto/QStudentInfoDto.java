package com.university.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.university.dto.QStudentInfoDto is a Querydsl Projection type for StudentInfoDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QStudentInfoDto extends ConstructorExpression<StudentInfoDto> {

    private static final long serialVersionUID = -1064287400L;

    public QStudentInfoDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<java.time.LocalDate> entranceDate, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<java.time.LocalDate> birthDate, com.querydsl.core.types.Expression<String> gender, com.querydsl.core.types.Expression<String> tel, com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<String> address, com.querydsl.core.types.Expression<String> departmentName, com.querydsl.core.types.Expression<Integer> grade, com.querydsl.core.types.Expression<Integer> semester) {
        super(StudentInfoDto.class, new Class<?>[]{long.class, java.time.LocalDate.class, String.class, java.time.LocalDate.class, String.class, String.class, String.class, String.class, String.class, int.class, int.class}, id, entranceDate, name, birthDate, gender, tel, email, address, departmentName, grade, semester);
    }

}

