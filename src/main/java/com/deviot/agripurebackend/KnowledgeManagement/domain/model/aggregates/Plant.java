package com.deviot.agripurebackend.KnowledgeManagement.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@Entity
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="scientific_name")
    private String scientificName;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="variety")
    private String variety;

    @Column(name="land_type")
    private String landType;

    @Column(name="weather_conditions")
    private String weatherConditions;

    @Column(name="distance_between_plants")
    private String distanceBetweenPlants;

    @Column(name="ideal_planting_depth")
    private String idealPlantingDepth;

    @Column(name = "fertilization_and_fumigation")
    private String fertilizationAndFumigation;
}
