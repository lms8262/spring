package com.university.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGradeScore is a Querydsl query type for GradeScore
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGradeScore extends EntityPathBase<GradeScore> {

    private static final long serialVersionUID = 1871291891L;

    public static final QGradeScore gradeScore = new QGradeScore("gradeScore");

    public final StringPath grade = createString("grade");

    public final NumberPath<Double> score = createNumber("score", Double.class);

    public QGradeScore(String variable) {
        super(GradeScore.class, forVariable(variable));
    }

    public QGradeScore(Path<? extends GradeScore> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGradeScore(PathMetadata metadata) {
        super(GradeScore.class, metadata);
    }

}

