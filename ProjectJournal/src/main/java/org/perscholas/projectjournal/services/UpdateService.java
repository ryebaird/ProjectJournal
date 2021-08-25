package org.perscholas.projectjournal.services;

import org.perscholas.projectjournal.dao.ProjectRepository;
import org.perscholas.projectjournal.dao.UpdatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UpdateService {
    private ProjectRepository projectRepository;
    private UpdatesRepository updatesRepository;


    @Autowired
    public void uService(ProjectRepository projectRepository,UpdatesRepository updatesRepository)
    {
        this.projectRepository = projectRepository;
        this.updatesRepository = updatesRepository;
    }





}
