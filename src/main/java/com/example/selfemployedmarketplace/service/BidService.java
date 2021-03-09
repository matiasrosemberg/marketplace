package com.example.selfemployedmarketplace.service;

import com.example.selfemployedmarketplace.exception.NotAvailableBidException;
import com.example.selfemployedmarketplace.exception.NotValidBidAmountException;
import com.example.selfemployedmarketplace.exception.NotValidBidException;
import com.example.selfemployedmarketplace.exception.NotValidProjectKeyException;
import com.example.selfemployedmarketplace.model.Bid;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BidService {

    private HashMap<Integer, Bid> biddings;

    public BidService() {
        this.biddings = new HashMap<>();
    }

    public boolean submitBid(Bid newBid) {

        Integer projectId = newBid.getProjectId();
        Double amount = newBid.getActualBid();
        Double lastBidAmount = biddings.get(projectId).getActualBid();

        validate(projectId, amount, lastBidAmount, newBid.getDevId());

        if (amount < lastBidAmount) {
            biddings.replace(projectId, newBid);
            return true;
        }
        return false;

    }

    public boolean hasPreviousBids(Bid newBid) {
        return biddings.containsKey(newBid.getProjectId());
    }

    private void validate(Integer projectId, Double amount, Double lastBidAmount, Integer devId) {
        if (!biddings.containsKey(projectId)) {
            throw new NotValidProjectKeyException("Invalid project ID, please, check it or ask for help.");
        }

        if (biddings.get(projectId).getDevId().equals(devId)){
            throw new NotValidBidException("The winning bid has the same devId than the new bid");
        }

        if (amount <= 0) {
            throw new NotValidBidAmountException("Invalid bid amount, please insert numbers between 0 < amount < maxAmount");
        }

        if (amount >= lastBidAmount) {
            throw new NotValidBidAmountException("Invalid bid amount, please insert numbers between 0 < amount < maxAmount");
        }
    }

    public boolean createBid(Bid newBid, Double maxBudget) {
        if (newBid.getActualBid() <= maxBudget) {
            biddings.put(newBid.getProjectId(), newBid);
            return true;
        }
        throw new NotValidBidAmountException("Invalid bid amount, please insert numbers between 0 < amount < maxAmount");
    }

    public Bid get(Integer projectId) {
        if (biddings.containsKey(projectId))
            return biddings.get(projectId);
        throw new NotAvailableBidException("This project has no bids.");
    }

    public HashMap<Integer, Bid> getBiddings() {
        return biddings;
    }

    public void setBiddings(HashMap<Integer, Bid> biddings) {
        this.biddings = biddings;
    }
}
