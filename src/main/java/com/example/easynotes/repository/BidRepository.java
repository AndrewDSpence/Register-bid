package com.example.easynotes.repository;

import com.example.easynotes.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @authour created by Eric Nelson 2022.1.7
 **/
@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

}
