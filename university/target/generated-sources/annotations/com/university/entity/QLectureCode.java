package com.university.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureCode is a Querydsl query type for LectureCode
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureCode extends EntityPathBase<LectureCode> {

    private static final long serialVersionUID = 743806611L;

    public static final QLectureCode lectureCode = new QLectureCode("lectureCode");

    public final StringPath detail = createString("detail");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QLectureCode(String variable) {
        super(LectureCode.class, forVariable(variable));
    }

    public QLectureCode(Path<? extends LectureCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureCode(PathMetadata metadata) {
        super(LectureCode.class, metadata);
    }

}

