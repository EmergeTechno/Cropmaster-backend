package com.deviot.cropmasterbackend.advisory.interfaces.rest;

import com.deviot.cropmasterbackend.advisory.application.internal.activity.ActivityCommandService;
import com.deviot.cropmasterbackend.advisory.application.internal.activity.ActivityQueryService;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.activity.CompleteActivityCommand;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.activity.CreateActivityCommand;
import com.deviot.cropmasterbackend.advisory.domain.model.commands.activity.DeleteActivityCommand;
import com.deviot.cropmasterbackend.advisory.domain.model.entities.Activity;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.activity.GetActivitiesByProjectId;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.activity.GetActivityByIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {
    private final ActivityCommandService activityCommandService;
    private final ActivityQueryService activityQueryService;

    @PostMapping
    public ResponseEntity<?> createActivity(@RequestBody CreateActivityCommand createActivityCommand){
        this.activityCommandService.handle(createActivityCommand);
        return ResponseEntity.ok("Activity created !!");
    }


    @GetMapping("/activityByProjectId/{projectId}")
    public ResponseEntity<?> getActivityByProjectId(@PathVariable("projectId") Long projectId){
        GetActivitiesByProjectId getActivitiesByProjectId=new GetActivitiesByProjectId(projectId);
        List<Activity> activities=this.activityQueryService.handle(getActivitiesByProjectId);
        if(activities!=null){
            return ResponseEntity.ok(activities);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/activityById/{activityId}")
    public ResponseEntity<?> getActivityById(@PathVariable("activityId") Long activityId){
        GetActivityByIdQuery getActivityByIdQuery=new GetActivityByIdQuery(activityId);
        Activity activity=this.activityQueryService.handle(getActivityByIdQuery);
        if(activity!=null){
            return ResponseEntity.ok(activity);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteActivityById/{activityId}")
    public ResponseEntity<?> deleteActivityById(@PathVariable("activityId") Long activityId){
        DeleteActivityCommand deleteActivityCommand=new DeleteActivityCommand(activityId);
        String message=this.activityCommandService.handle(deleteActivityCommand);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/completeActivity/{activityId}")
    public ResponseEntity<?> completeActivityById(@PathVariable("activityId") Long activityId){
        CompleteActivityCommand completeActivityCommand=new CompleteActivityCommand(activityId);
        String message=this.activityCommandService.handle(completeActivityCommand);
        return ResponseEntity.ok(message);
    }

}
