package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @authour created by Eric Nelson 2022.1.7
 **/
@Entity
@Table(name = "bid_log")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank
    private String user_name;

//    @NotBlank
    private String bid_statement;

//    @NotBlank
    private Long client_price;

    @Column(nullable = false)
//    @NotBlank
    private String client_name;

    private String client_country;

    @Column(nullable = false)
//    @NotBlank
    private Long client_verify_id;

    @Column(nullable = false)
//    @NotBlank
    private Long client_verify_payment;

//    @NotBlank
    private String client_join_date;

//    @NotBlank
    private String chat;

    private Long bid_num;

    private Long del_flag;

    private String when_jobs;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getBid_statement() {
        return bid_statement;
    }

    public void setBid_statement(String bid_statement) {
        this.bid_statement = bid_statement;
    }

    public Long getClient_price() {
        return client_price;
    }

    public void setClient_price(Long client_price) {
        this.client_price = client_price;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_country() {
        return client_country;
    }

    public void setClient_country(String client_country) {
        this.client_country = client_country;
    }

    public Long getClient_verify_id() {
        return client_verify_id;
    }

    public void setClient_verify_id(Long client_verify_id) {
        this.client_verify_id = client_verify_id;
    }

    public Long getClient_verify_payment() {
        return client_verify_payment;
    }

    public void setClient_verify_payment(Long client_verify_payment) {
        this.client_verify_payment = client_verify_payment;
    }

    public void setDel_flag(Long del_flag){
        this.del_flag = del_flag;
    }

    public Long getDel_flag(){
        return this.del_flag;
    }

    public String getClient_join_date() {
        return client_join_date;
    }

    public void setClient_join_date(String client_join_date) {
        this.client_join_date = client_join_date;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public Long getBid_num() {
        return bid_num;
    }

    public void setBid_num(Long bid_num){
        this.bid_num = bid_num;
    }

    public String getWhen_jobs(){
        return when_jobs;
    }

    public void setWhen_jobs(String when_jobs){
        this.when_jobs = when_jobs;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isEmpty(){
        if(user_name.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}

