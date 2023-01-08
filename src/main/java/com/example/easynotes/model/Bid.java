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

    @NotBlank
    private String client_name;

    @Column(nullable = false)
//    @NotBlank
    private Long client_verify_id;

    @Column(nullable = false)
//    @NotBlank
    private Long client_verify_payment;

    @Column(nullable = false)
//    @NotBlank
    private Long price;

//    @NotBlank
    private Long  pay_type;

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

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public Long getPay_type() {
        return pay_type;
    }

    public void setPay_type(Long pay_type) {
        this.pay_type = pay_type;
    }

    public Long getClient_verify_payment() {
        return client_verify_payment;
    }

    public void setClient_verify_payment(Long client_verify_payment) {
        this.client_verify_payment = client_verify_payment;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long id) {
        this.price = id;
    }

    public Long getClient_verify_id() {
        return client_verify_id;
    }

    public void setClient_verify_id(Long client_verify_id) {
        this.client_verify_id = client_verify_id;
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

}

