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
public class Update {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int updateId;
    @NotNull
    @NonNull
    private int projectId;
    @NotNull
    @NonNull
    private Date updateCreatedOn;

    @OneToMany
    List<Part> parts;
}
