package com.example.selfemployedmarketplace.service;

import com.example.selfemployedmarketplace.exception.NotValidProjectKeyException;
import com.example.selfemployedmarketplace.model.Bid;
import com.example.selfemployedmarketplace.model.Project;
import com.example.selfemployedmarketplace.model.ProjectData;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;

@Service
public class ProjectService {

    private HashMap<Integer, Project> projects;
    private Integer lastId;

    public ProjectService() {
        this.projects = new HashMap<>();
        this.lastId = 0;
    }

    public Project create(ProjectData newProjectData) {

        Integer newId = lastId + 1;
        LocalDate newLocalDate = LocalDate.now();

        Project project = new Project(newId, newLocalDate, newProjectData);

        projects.put(newId, project);

        lastId = newId;

        return project;
    }

    public Project get(Integer id) {
        if (projects.containsKey(id))
            return projects.get(id);
        throw new NotValidProjectKeyException("Failed to retreive a project with that id, please check id inserted.");
    }

    public boolean isOpen(Bid bid) {
        return bid.getCreatedAt().isBefore(projects.get(bid.getProjectId()).getProjectData().getBidEndingTime());
    }
}
