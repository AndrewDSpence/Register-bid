package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Bid;
import com.example.easynotes.model.Chat;
import com.example.easynotes.repository.BidRepository;
import com.example.easynotes.repository.ChatRepository;
import com.example.easynotes.repository.NoteRepository;
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
public class ChatController {

    @Autowired
    ChatRepository chatRepository;

    @GetMapping("/chats")
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    @PostMapping("/chats")
    public Chat createChat(@Valid @RequestBody Chat chat) {
        return chatRepository.save(chat);
    }

    @GetMapping("/chats/{id}")
    public Chat getChatById(@PathVariable(value = "id") Long ChatId) {
        return chatRepository.findById(ChatId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat", "id", ChatId));
    }

    @PutMapping("/chats/{id}")
    public Chat updateBid(@PathVariable(value = "id") Long chatId,
                         @Valid @RequestBody Chat chatDetails) {

        Chat Chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat", "id", chatId));

        Chat.setMessage(chatDetails.getMessage());

        Chat updatedChat = chatRepository.save(Chat);
        return updatedChat;
    }

    @DeleteMapping("/chats/{id}")
    public ResponseEntity<?> deleteChat(@PathVariable(value = "id") Long bidId) {
        Chat bid = chatRepository.findById(bidId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat", "id", bidId));

        chatRepository.delete(bid);

        return ResponseEntity.ok().build();
    }
}
