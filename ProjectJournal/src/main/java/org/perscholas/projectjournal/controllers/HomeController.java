package org.perscholas.projectjournal.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.projectjournal.models.Project;
import org.perscholas.projectjournal.models.Update;
import org.perscholas.projectjournal.models.User;
import org.perscholas.projectjournal.dao.ProjectRepository;
import org.perscholas.projectjournal.dao.UpdateRepository;
import org.perscholas.projectjournal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class homeController {

    private UserService userService;
    private ProjectRepository projectRepository;
    private UpdateRepository updateRepository;

    @Autowired
    public homeController(UserService userService, ProjectRepository projectRepository, UpdateRepository updateRepository)
    {
        this.updateRepository = updateRepository;
        this.projectRepository = projectRepository;
        this.userService = userService;

    }

    @GetMapping("/form")
    public String formpage(Model model){
    return "form";
    }

    @PostMapping("/form")
    public String homepage(@RequestParam("projDesc") String projDesc, @RequestParam("projName") String projName, Model model)
    {
        Project project = new Project(1,projDesc,projName);
        projectRepository.save(project);
        User user = userService.getUserById(1);
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/")
    public String homepage(Model model)
    {
        userService.populateUserData();
        Project proj = new Project(1,"Grow Room","Room for growing plants");
        projectRepository.save(proj);
        Project proj2 = new Project(3,"RV Renovation","Renovating my RV");
        Update upd1 = new Update(4,"First Update","Started clearing the space for my grow room!");
        updateRepository.save(upd1);
        projectRepository.save(proj2);
        User user = userService.getUserById(1);
        model.addAttribute("user", user);
        List<Project> projects = projectRepository.findAllByUserId(1);
        model.addAttribute("projects", projects);

        return "index";
    }

    @GetMapping("/projectpage")
    public String projpage(@RequestParam("id") Integer projId, Model model){
       log.warn("Got here!" + projId.toString());
        Project proj = projectRepository.findByProjectId(projId);
        List<Update> updates = updateRepository.findAllByProjectId(4);
        model.addAttribute("project", proj);
        model.addAttribute("updates", updates);
        return "projectpage";
    }


    @GetMapping("/account")
    public String accountPage(Model model)
    {
        User user = userService.getUserById(1);
        model.addAttribute("user", user);
        return "account";

    }





}
