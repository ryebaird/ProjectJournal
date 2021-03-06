package org.perscholas.projectjournal.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.projectjournal.dao.ProjectRepository;
import org.perscholas.projectjournal.models.Project;
import org.perscholas.projectjournal.models.User;
import org.perscholas.projectjournal.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@Service
public class UserService {
    private UserRepository userRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public void newService(UserRepository userRepository, ProjectRepository projectRepository)
    {
        this.userRepository=userRepository;
        this.projectRepository=projectRepository;
    }

    public void deleteUser(User u){
        Optional<User> user = userRepository.findByUserId(u.getUserId());

        if (user.isPresent()){
            userRepository.delete(user.get());
        }
        else
        {
            throw new EntityNotFoundException("The user was not found in the database");
        }
    }

    public void populateData(){
        User user = new User("ryebaird","Ryan","Baird","Password","1289 S Warner Dr.","Apache Junction","Az","USA",42,true);
        User user1 = new User("jbaird","Charles","Baird","Password","1289 S Warner Dr.","Apache Junction","Az","USA",44,true);
        User user2 = new User("kstorm","Krystal","Storm","Password","1289 S Warner Dr.","Apache Junction","Az","USA",40,true);
        Project project = new Project("Grow Room","Space dedicated for growing plants via hydroponics",true);
        Project project1 = new Project("RV remodel","Remodeling an RV to include new features and windows",true);
        projectRepository.saveAll(Arrays.asList(project,project1));


        List<Project> listpro = user.getProjects();
        listpro.add(project);
        log.warn(listpro.toString());
//        listpro.add(project);
//        user.setProjects(listpro);

        userRepository.saveAll(Arrays.asList(user,user1,user2));


    }

    public User addUser(User u){
        Optional<User> user = userRepository.findByUserId(u.getUserId());

        if (user.isEmpty())
        {
            log.warn("Saving User: "+ u.getUserName());
            userRepository.save(u);
            return u;
        }
        else
        {
            log.warn("The userId is already in use");
            return null;
        }
    }

    public void updateUser(User u){
        Optional<User> user = userRepository.findByUserId(u.getUserId());

        if (user.isEmpty())
        {
            userRepository.save(u);
        }
        else
        {
            throw new EntityExistsException("The userId is already in use");
        }
    }

}
