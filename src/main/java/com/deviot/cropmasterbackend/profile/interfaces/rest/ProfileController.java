package com.deviot.cropmasterbackend.profile.interfaces.rest;
import com.deviot.cropmasterbackend.account.application.internal.AccountCommandService;
import com.deviot.cropmasterbackend.account.application.internal.QueryService.AccountQueryService;
import com.deviot.cropmasterbackend.account.domain.model.aggregates.Account;
import com.deviot.cropmasterbackend.account.domain.model.commands.DeleteAccountCommand;
import com.deviot.cropmasterbackend.account.domain.model.enums.AccountRol;
import com.deviot.cropmasterbackend.account.domain.model.queries.GetAccountByEmailQuery;
import com.deviot.cropmasterbackend.account.domain.model.queries.GetEmailAndTypeByAccountIdQuery;
import com.deviot.cropmasterbackend.account.domain.model.queries.GetSpecialistsQuery;
import com.deviot.cropmasterbackend.profile.application.internal.ProfileCommandService;
import com.deviot.cropmasterbackend.profile.application.internal.QueryService.ProfileQueryService;
import com.deviot.cropmasterbackend.profile.application.internal.QueryService.SpecialistQueryService;
import com.deviot.cropmasterbackend.profile.application.internal.SpecialistCommandService;
import com.deviot.cropmasterbackend.profile.domain.model.aggregates.Profile;
import com.deviot.cropmasterbackend.profile.domain.model.aggregates.Specialist;
import com.deviot.cropmasterbackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.cropmasterbackend.profile.domain.model.commands.DeleteProfileCommand;
import com.deviot.cropmasterbackend.profile.domain.model.commands.UpdateProfileCommand;
import com.deviot.cropmasterbackend.profile.domain.model.commands.specialist.DeleteSpecialistCommand;
import com.deviot.cropmasterbackend.profile.domain.model.queries.GetProfileByAccountIdQuery;
import com.deviot.cropmasterbackend.profile.domain.model.queries.specialist.GetSpecialistByAccountIdQuery;
import com.deviot.cropmasterbackend.profile.interfaces.rest.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;
    private final AccountQueryService accountQueryService;
    private final SpecialistQueryService specialistQueryService;
    private final SpecialistCommandService specialistCommandService;
    private final AccountCommandService accountCommandService;

    @PostMapping
    public ResponseEntity<?> createProfile(@RequestBody CreateProfileCommand createProfileCommand){
        this.profileCommandService.handle(createProfileCommand);
        return ResponseEntity.ok("Profile created!!!");
    }
    @GetMapping("/getProfile/{accountId}")
    public ResponseEntity<?> getUserByAccountId(@PathVariable("accountId")Long accountId){
        GetProfileByAccountIdQuery getProfileByAccountIdQuery=new GetProfileByAccountIdQuery(accountId);
        GetEmailAndTypeByAccountIdQuery getEmailAndTypeByAccountIdQuery =new GetEmailAndTypeByAccountIdQuery(accountId);

        Profile profile=this.profileQueryService.handle(getProfileByAccountIdQuery);
        Account account=this.accountQueryService.handle(getEmailAndTypeByAccountIdQuery);

        if (profile!=null && account!=null){
            User user=User.builder()
                    .email(account.getEmail())
                    .name(profile.getName())
                    .description(profile.getDescription())
                    .imageUrl(profile.getImageUrl())
                    .location(profile.getLocation())
                    .type(account.getRol().toString())
                    .planId(profile.getPlanId())
                    .accountId(profile.getAccountId())
                    .build();

            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getProfileByEmail/{email}")
    public ResponseEntity<?> getUserByAccountEmail(@PathVariable("email")String email){
        GetAccountByEmailQuery getAccountByEmailQuery=new GetAccountByEmailQuery(email);
        Account account= this.accountQueryService.handle(getAccountByEmailQuery);

        GetProfileByAccountIdQuery getEmailAndTypeByAccountIdQuery=new GetProfileByAccountIdQuery(account.getId());
        Profile profile=this.profileQueryService.handle(getEmailAndTypeByAccountIdQuery);

        if (profile != null){
            User user=User.builder()
                    .email(account.getEmail())
                    .name(profile.getName())
                    .description(profile.getDescription())
                    .imageUrl(profile.getImageUrl())
                    .location(profile.getLocation())
                    .type(account.getRol().toString())
                    .planId(profile.getPlanId())
                    .accountId(profile.getAccountId())
                    .build();

            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getSpecialistInfoByAccountId/{accountId}")
    public ResponseEntity<?> getSpecialistInfoByAccountId(@PathVariable("accountId")Long accountId){
        GetSpecialistByAccountIdQuery getSpecialistByAccountIdQuery=new GetSpecialistByAccountIdQuery(accountId);
        Specialist specialist=this.specialistQueryService.handle(getSpecialistByAccountIdQuery);
        if (specialist!=null ){
            return ResponseEntity.ok(specialist);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getSpecialists")
    public ResponseEntity<?>getAllProfilesBySpecialistType(){
        GetSpecialistsQuery getSpecialistsQuery =new GetSpecialistsQuery(AccountRol.SPECIALIST);
        List<Account> accounts=this.accountQueryService.handle(getSpecialistsQuery);
        if (accounts != null) {
            List<User> users = new ArrayList<>();

            for (Account account : accounts) {
                GetProfileByAccountIdQuery getProfileByAccountIdQuery = new GetProfileByAccountIdQuery(account.getId());
                GetEmailAndTypeByAccountIdQuery getEmailAndTypeByAccountIdQuery = new GetEmailAndTypeByAccountIdQuery(account.getId());

                Profile profile = this.profileQueryService.handle(getProfileByAccountIdQuery);

                if (profile != null) {
                    User user = User.builder()
                            .email(account.getEmail())
                            .name(profile.getName())
                            .description(profile.getDescription())
                            .imageUrl(profile.getImageUrl())
                            .location(profile.getLocation())
                            .type(account.getRol().toString())
                            .planId(profile.getPlanId())
                            .accountId(profile.getAccountId())
                            .build();
                    users.add(user);
                }
            }

            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProfileByAccountId(@RequestBody UpdateProfileCommand updateProfileCommand){
        String message=this.profileCommandService.handle(updateProfileCommand);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/deleteProfile/{accountId}")
    public ResponseEntity<?> deleteProfileByAccountId(@PathVariable("accountId")Long accountId){

        GetProfileByAccountIdQuery getProfileByAccountIdQuery=new GetProfileByAccountIdQuery(accountId);

        Profile profile=this.profileQueryService.handle(getProfileByAccountIdQuery);
        if(!profile.getClass().toString().equals("SPECIALIST")){
            DeleteSpecialistCommand deleteSpecialistCommand=new DeleteSpecialistCommand(accountId);
            this.specialistCommandService.handle(deleteSpecialistCommand);
        }

        DeleteProfileCommand deleteProfileCommand=new DeleteProfileCommand(accountId);
        DeleteAccountCommand deleteAccountCommand=new DeleteAccountCommand(accountId);
        String profileMessage=this.profileCommandService.handle(deleteProfileCommand);
        String accountMessage=this.accountCommandService.handle(deleteAccountCommand);
        return ResponseEntity.ok(profileMessage+accountMessage);
    }
}
