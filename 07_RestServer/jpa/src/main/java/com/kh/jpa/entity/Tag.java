package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TAG")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAG_ID")
    private Long tagId;

    @Column(name ="TAG_NAME", nullable = false, length = 30, unique = true)
    private String tagName;

    @OneToMany(mappedBy = "tagId", fetch = FetchType.LAZY)
    private List<BoardTag> boardTags = new ArrayList<>();
}
