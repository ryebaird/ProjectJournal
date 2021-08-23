package org.perscholas.projectjournal.services;

import org.perscholas.projectjournal.dao.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;
    @Autowired
    public void pService(ProjectRepository projectRepository)
    {
        this.projectRepository = projectRepository;
    }


}
