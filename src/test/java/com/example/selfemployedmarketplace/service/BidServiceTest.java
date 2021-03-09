package com.example.selfemployedmarketplace.service;

import com.example.selfemployedmarketplace.exception.NotAvailableBidException;
import com.example.selfemployedmarketplace.exception.NotValidBidAmountException;
import com.example.selfemployedmarketplace.exception.NotValidBidException;
import com.example.selfemployedmarketplace.model.Bid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BidServiceTest {

    @InjectMocks
    BidService bidService = new BidService();

    @BeforeEach
    void fill(){
        HashMap<Integer, Bid> someBiddings = new HashMap<>();
        someBiddings.put(1,generateBid(1,10D,23));
        someBiddings.put(2,generateBid(2,100D,12));
        someBiddings.put(3,generateBid(3,50D,54));
        bidService.setBiddings(someBiddings);
    }

    @Test
    void submitBid() {
        Bid bid = generateBid(3,40D,32);
        bidService.submitBid(bid);
        Assertions.assertEquals(bid,bidService.get(3));
    }

    @Test
    void submitBadBid() {
        Bid bid = generateBid(1,20D,32);
        Assertions.assertThrows(NotValidBidAmountException.class,() -> bidService.submitBid(bid));
    }

    @Test
    void submitBadBidSameDevId() {
        Bid bid = generateBid(1,5D,23);
        Assertions.assertThrows(NotValidBidException.class,() -> bidService.submitBid(bid));
    }

    @Test
    void hasPreviousBids() {
        assertTrue(bidService.hasPreviousBids(generateBid(3,40D,32)));
    }

    @Test
    void hasNoPreviousBids() {
        assertFalse(bidService.hasPreviousBids(generateBid(5,40D,32)));
    }

    @Test
    void createBid() {
        Bid bid = generateBid(4,40D,32);
        bidService.createBid(bid,100D);
        assertEquals(bid,bidService.get(4));
    }

    @Test
    void createBadBid() {
        Bid bid = generateBid(4,40D,32);
        assertThrows(NotValidBidAmountException.class, () -> bidService.createBid(bid,20D));
    }

    @Test
    void get() {
        assertEquals(generateBid(3,50D,54),bidService.get(3));
    }

    @Test
    void getNonExistent() {
        assertThrows(NotAvailableBidException.class,() -> bidService.get(4));
    }

    private Bid generateBid(Integer project, Double amount, Integer dev){
        return new Bid(project,amount,dev);
    }

}