package com.example.selfemployedmarketplace.controller;

import com.example.selfemployedmarketplace.model.Bid;
import com.example.selfemployedmarketplace.service.BidService;
import com.example.selfemployedmarketplace.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/buyer")
public class BuyerController {

    private BidService bidService;
    private ProjectService projectService;

    @Autowired
    public BuyerController(BidService bidService, ProjectService projectService) {
        this.bidService = bidService;
        this.projectService = projectService;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public boolean newBid(@RequestBody Bid newBid) {
        if( bidService.hasPreviousBids(newBid) )
            return projectService.isOpen(newBid) && bidService.submitBid(newBid);
        else
            return projectService.isOpen(newBid) && bidService.createBid(newBid,projectService.get(newBid.getProjectId()).getProjectData().getMaxBudget());
    }
}