package org.perscholas.projectjournal.models;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int imageId;
    @NotNull
    @NonNull
    private String imageName;
    @NotNull
    @NonNull
    private int updateId;
}
