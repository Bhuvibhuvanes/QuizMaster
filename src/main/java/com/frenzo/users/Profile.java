package com.frenzo.users;

import java.time.ZonedDateTime;

import com.frenzo.entity.UserInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo user;

    private String rollNumber;

    private String institute;

    private String department;

    private String position;

    private boolean isModerator;

    private String timezone;

    private boolean isEmailVerified;

    private String activationKey;

    private ZonedDateTime keyExpiryTime;
}
