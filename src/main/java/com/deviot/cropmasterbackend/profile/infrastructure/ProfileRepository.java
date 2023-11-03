package com.deviot.cropmasterbackend.profile.infrastructure;

import com.deviot.cropmasterbackend.profile.domain.model.aggregates.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findProfileByAccountId(Long accountId);
}
