package com.university.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLectureRegistration is a Querydsl query type for LectureRegistration
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureRegistration extends EntityPathBase<LectureRegistration> {

    private static final long serialVersionUID = 2124598111L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLectureRegistration lectureRegistration = new QLectureRegistration("lectureRegistration");

    public final QLecture lecture;

    public final QStudent student;

    public QLectureRegistration(String variable) {
        this(LectureRegistration.class, forVariable(variable), INITS);
    }

    public QLectureRegistration(Path<? extends LectureRegistration> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLectureRegistration(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLectureRegistration(PathMetadata metadata, PathInits inits) {
        this(LectureRegistration.class, metadata, inits);
    }

    public QLectureRegistration(Class<? extends LectureRegistration> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new QLecture(forProperty("lecture"), inits.get("lecture")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }

}

