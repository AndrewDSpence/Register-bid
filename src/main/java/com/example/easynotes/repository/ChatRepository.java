package com.example.easynotes.repository;

import com.example.easynotes.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @authour created by Eric Nelson 2022.1.7
 **/
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

}
