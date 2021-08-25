package org.perscholas.projectjournal.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.projectjournal.models.Project;
import org.perscholas.projectjournal.models.Updates;
import org.perscholas.projectjournal.models.User;
import org.perscholas.projectjournal.dao.ProjectRepository;
import org.perscholas.projectjournal.dao.UpdatesRepository;
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
    private UpdatesRepository updatesRepository;

    @Autowired
    public homeController(UserService userService, ProjectRepository projectRepository, UpdatesRepository updatesRepository)
    {
        this.updatesRepository = updatesRepository;
        this.projectRepository = projectRepository;
        this.userService = userService;

    }
    @GetMapping("/NewProject")
    public String getNewProjectPage(Model model){
        return "NewProject";
    }


    @PostMapping("/NewProject")
    public String homepage(@RequestParam("projDesc") String projDesc, @RequestParam("projName") String projName, Model model)
    {
        Project project = new Project(1,projDesc,projName);
        projectRepository.save(project);
        User user = userService.getUserById(1);
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping("/projectpage")
    public String newupdatepage(@RequestParam("updDesc") String updDesc, @RequestParam("updText") String updText, @RequestParam("id") Integer projId, Model model)
    {
        Updates update = new Updates(projId,updDesc,updText);
        updatesRepository.save(update);
        User user = userService.getUserById(1);
        model.addAttribute("user", user);
        return "projectpage";
    }

    @GetMapping("/")
    public String homepage(Model model)
    {

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
        List<Updates> updates = updatesRepository.findAllByProjectId(projId);
        log.warn(updates.toString());
        User user = userService.getUserById(1);
        model.addAttribute("user",user);
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
