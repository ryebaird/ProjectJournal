package org.perscholas.projectjournal.services;

import org.perscholas.projectjournal.dao.ProjectRepository;
import org.perscholas.projectjournal.dao.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;
    private UpdateRepository updateRepository;


    @Autowired
    public void pService(ProjectRepository projectRepository,UpdateRepository updateRepository)
    {
        this.projectRepository = projectRepository;
        this.updateRepository = updateRepository;

    }

}
