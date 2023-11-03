package com.deviot.agripurebackend.advisory.domain.model.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "activities")
@Builder
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "project_id")
    private long projectId;

    @Column(name = "title")
    private String title;

    @Column(name="date")
    private Date date;

    @Column(name = "completed")
    private boolean completed;

}
