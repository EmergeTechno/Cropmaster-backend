package com.deviot.cropmasterbackend.profile.infrastructure;

import com.deviot.cropmasterbackend.profile.domain.model.aggregates.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
    Specialist findSpecialistByAccountId(Long accountId);
}
