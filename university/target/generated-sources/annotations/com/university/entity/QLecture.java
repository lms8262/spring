package com.university.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLecture is a Querydsl query type for Lecture
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLecture extends EntityPathBase<Lecture> {

    private static final long serialVersionUID = -1283414138L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLecture lecture = new QLecture("lecture");

    public final NumberPath<Integer> capacity = createNumber("capacity", Integer.class);

    public final NumberPath<Integer> credit = createNumber("credit", Integer.class);

    public final StringPath day = createString("day");

    public final QDepartment department;

    public final NumberPath<Integer> endTime = createNumber("endTime", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLectureCode lectureCode;

    public final QLectureRoom lectureRoom;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> numOfStudent = createNumber("numOfStudent", Integer.class);

    public final QProfessor professor;

    public final NumberPath<Integer> semester = createNumber("semester", Integer.class);

    public final NumberPath<Integer> startTime = createNumber("startTime", Integer.class);

    public final StringPath type = createString("type");

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QLecture(String variable) {
        this(Lecture.class, forVariable(variable), INITS);
    }

    public QLecture(Path<? extends Lecture> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLecture(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLecture(PathMetadata metadata, PathInits inits) {
        this(Lecture.class, metadata, inits);
    }

    public QLecture(Class<? extends Lecture> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QDepartment(forProperty("department"), inits.get("department")) : null;
        this.lectureCode = inits.isInitialized("lectureCode") ? new QLectureCode(forProperty("lectureCode")) : null;
        this.lectureRoom = inits.isInitialized("lectureRoom") ? new QLectureRoom(forProperty("lectureRoom"), inits.get("lectureRoom")) : null;
        this.professor = inits.isInitialized("professor") ? new QProfessor(forProperty("professor"), inits.get("professor")) : null;
    }

}

