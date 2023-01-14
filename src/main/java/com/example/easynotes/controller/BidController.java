package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Bid;
import com.example.easynotes.model.ResponseBid;
import com.example.easynotes.model.ResponseData;
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
@CrossOrigin
@RequestMapping("/api")
public class BidController {

    @Autowired
    BidRepository bidRepository;

    @GetMapping("/bids")
    public List<Bid> getAllBids() {
       return bidRepository.findAllBid();
    }

    @PostMapping(value= "/bids")
<<<<<<< HEAD
    public Bid createBid(@Valid @RequestBody Bid bid) {
        return bidRepository.save(bid);
=======
    public ResponseBid createBid(@Valid Bid bid) {
        if(bid.getUser_name()!=null){
            if(bid.getBid_statement()!=null){
                bidRepository.save(bid);
                return new ResponseBid("200","Success", bid);
            }else {
                return new ResponseBid("407","Not Exists", "bid_statement Not exists");
            }
        }
        else
            return new ResponseBid("407","Not Exists", "username Not exists");
>>>>>>> cfec87812ed38c50f6652a78fa9c09c9f53bc967
    }

    @GetMapping("/bids/{id}")
    public Bid getBidById(@PathVariable(value = "id") @RequestBody Long BidId) {
        return bidRepository.findById(BidId)
                .orElseThrow(() -> new ResourceNotFoundException("Bid", "id", BidId));
    }

    @PutMapping("/bids/{id}")
    public Bid updateBid(@PathVariable(value = "id") Long Bidid,
<<<<<<< HEAD
                           @Valid  @RequestBody Bid BidDetails) {

=======
                           @Valid  Bid BidDetails) {
>>>>>>> cfec87812ed38c50f6652a78fa9c09c9f53bc967
        Bid bid = bidRepository.findById(Bidid)
                .orElseThrow(() -> new ResourceNotFoundException("Bid", "id", Bidid));
        Bid updatedBid = bidRepository.save(BidDetails);
        return updatedBid;
    }

    @DeleteMapping("/bids/{id}")
    public ResponseBid deleteBid(@PathVariable(value = "id") Long bidId) {
//        ResponseBid resdata;
//        Bid bid = bidRepository.findById(bidId)
//                .orElseThrow(() -> new ResourceNotFoundException("Bid", "id", bidId));
//        bid.setDel_flag((long) 1);
//        Bid updatedBid = bidRepository.save(bid);
//        resdata = new ResponseBid("200","Success", updatedBid);
//        return resdata;
        bidRepository.deleteBid(bidId);
        return new ResponseBid("200","wer","");
    }
}
