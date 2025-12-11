package com.kh.jpa.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardTagId implements Serializable {
    private Long tagId;
    private Long boardId;
}
