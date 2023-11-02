package com.deviot.agripurebackend.notification.domain.model.aggregates;

import com.deviot.agripurebackend.notification.domain.model.enums.NotificationImportance;
import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Data
@Builder
@Entity
@Table(name = "notifications")
@AllArgsConstructor
@NoArgsConstructor
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "specialist_id")
    private Long specialistId;

    @Column(name = "created_at")
    private Date createAt;

    @Column(name = "plant_id")
    private Long plantId;

    @Column(name = "seen")
    private Boolean seen;

    @Column(name = "message")
    private String message;

    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "importance")
    private NotificationImportance importance;

}

