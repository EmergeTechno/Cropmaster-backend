package com.deviot.cropmasterbackend.KnowledgeManagement.infrastructure;

import com.deviot.cropmasterbackend.KnowledgeManagement.domain.model.aggregates.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Long> {
}
