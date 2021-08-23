package org.perscholas.projectjournal.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.projectjournal.models.User;
import org.perscholas.projectjournal.dao.PartRepository;
import org.perscholas.projectjournal.dao.ProjectRepository;
import org.perscholas.projectjournal.dao.UpdateRepository;
import org.perscholas.projectjournal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@Controller
public class homeController {

    private UserService userService;
    private ProjectRepository projectRepository;
    private PartRepository partRepository;
    private UpdateRepository updateRepository;

    @Autowired
    public homeController(UserService userService, ProjectRepository projectRepository, UpdateRepository updateRepository, PartRepository partRepository)
    {
        this.updateRepository = updateRepository;
        this.projectRepository = projectRepository;
        this.partRepository = partRepository;
        this.userService = userService;

    }

    @GetMapping("/home")
    public String homepage(Model model)
    {
        userService.populateData();
        return "index";
    }

}
