package com.deviot.cropmasterbackend.advisory.infrastructure;

import com.deviot.cropmasterbackend.advisory.domain.model.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    List<Activity> findActivitiesByProjectId(Long id);
}
