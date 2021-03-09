package com.example.selfemployedmarketplace.controller;

import com.example.selfemployedmarketplace.model.Project;
import com.example.selfemployedmarketplace.model.ProjectAndBid;
import com.example.selfemployedmarketplace.model.ProjectData;
import com.example.selfemployedmarketplace.service.BidService;
import com.example.selfemployedmarketplace.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/seller")
public class SellerController {

    private ProjectService projectService;
    private BidService bidService;

    @Autowired
    public SellerController(ProjectService projectService, BidService bidService) {
        this.projectService = projectService;
        this.bidService = bidService;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Project newProject(@RequestBody ProjectData newProjectData){
        return projectService.create(newProjectData);
    }

    @GetMapping("/{id}")
    public ProjectAndBid getProject(@PathVariable Integer id){
         return new ProjectAndBid(projectService.get(id),bidService.get(id));
    }

}