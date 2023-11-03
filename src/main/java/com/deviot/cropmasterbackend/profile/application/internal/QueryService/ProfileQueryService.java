package com.deviot.cropmasterbackend.profile.application.internal.QueryService;
import com.deviot.cropmasterbackend.profile.domain.model.aggregates.Profile;
import com.deviot.cropmasterbackend.profile.domain.model.queries.GetProfileByAccountIdQuery;
import com.deviot.cropmasterbackend.profile.domain.service.queryService.IProfileQueryService;
import com.deviot.cropmasterbackend.profile.infrastructure.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileQueryService implements IProfileQueryService {
    private final ProfileRepository profileRepository;

    @Override
    public Profile handle(GetProfileByAccountIdQuery getProfileByAccountIdQuery){
        Optional<Profile> profile= Optional.ofNullable(profileRepository.findProfileByAccountId(getProfileByAccountIdQuery.accountId()));
        if(profile.isPresent()){
            return profile.get();
        }else{
            return null;
        }
    }
}
