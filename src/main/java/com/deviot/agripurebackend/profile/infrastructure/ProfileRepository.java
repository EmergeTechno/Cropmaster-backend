package com.deviot.agripurebackend.profile.infrastructure;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
    List<Profile> findProfileByUserId(Long userId);
}