package com.example.easynotes.repository;

import com.example.easynotes.model.Bid;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @authour created by Eric Nelson 2022.1.7
 **/
@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    @Query(value = "SELECT * FROM BID_LOG WHERE DEL_FLAG = 0 ORDER BY ID DESC " , nativeQuery = true)
    List<Bid> findAllBid();

    @Transactional
    @Modifying
    @Query(value = "UPDATE BID_LOG SET DEL_FLAG = 1 WHERE ID = :id", nativeQuery = true)
    void deleteBid(@Param(value = "id") Long id);
}
