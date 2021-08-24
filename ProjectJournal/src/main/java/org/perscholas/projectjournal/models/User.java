package org.perscholas.projectjournal.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @NotNull
    @NonNull
    private String userName;
    @NotNull
    @NonNull
    private String userEmail;
    @NotNull
    @NonNull
    private String userFirst;
    @NotNull
    @NonNull
    private String userLast;

    @NotNull
    @NonNull
    private String userPassword;
    @NotNull
    @NonNull
    private String userAddress1;
    private String userAddress2;
    @NotNull
    @NonNull
    private String userCity;
    @NotNull
    @NonNull
    private String userState;
    @NotNull
    @NonNull
    private String userCountry;
    @NotNull
    @NonNull
    private int userAge;
    @NotNull
    @NonNull
    private Date userCreatedOn = new Date();
    @NotNull
    @NonNull
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    List<Project> projects;

    @OneToMany(cascade = CascadeType.ALL)
    List<Project> watchedProjects;



}
