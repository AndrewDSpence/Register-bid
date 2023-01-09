package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Bid;
import com.example.easynotes.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.validation.Valid;
import java.util.List;

/**
 * @authour created by Eric Nelson 2022.1.7
 **/
@RestController
@RequestMapping("/api")
public class BidController {

    @Autowired
    BidRepository bidRepository;

    @GetMapping("/bids")
    public List<Bid> getAllBids() {
       return bidRepository.findAll();
    }

    @PostMapping("/bids")
    public Bid createBid(@Valid @RequestBody Bid bid) {
        return bidRepository.save(bid);
    }

    @GetMapping("/bids/{id}")
    public Bid getBidById(@PathVariable(value = "id") Long BidId) {
        return bidRepository.findById(BidId)
                .orElseThrow(() -> new ResourceNotFoundException("Bid", "id", BidId));
    }

    @PutMapping("/bids/{id}")
    public Bid updateBid(@PathVariable(value = "id") Long Bidid,
                           @Valid @RequestBody Bid BidDetails) {

        Bid bid = bidRepository.findById(Bidid)
                .orElseThrow(() -> new ResourceNotFoundException("Bid", "id", Bidid));
        Bid updatedNote = bidRepository.save(bid);
        return updatedNote;
    }

    @DeleteMapping("/bids/{id}")
    public ResponseEntity<?> deleteBid(@PathVariable(value = "id") Long bidId) {
        Bid bid = bidRepository.findById(bidId)
                .orElseThrow(() -> new ResourceNotFoundException("Bid", "id", bidId));

        bidRepository.delete(bid);
        return ResponseEntity.ok().build();
    }
}
