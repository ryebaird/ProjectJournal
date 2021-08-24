package org.perscholas.projectjournal.models;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;
    @NotNull
    @NonNull
    private int userId;
    @NotNull
    @NonNull
    private String projectName;
    @NotNull
    @NonNull
    private String projectDescription;
    @NotNull
    @NonNull
    private Date projectCreatedOn = new Date();



    @OneToMany
    private List<Update> updates;

}
