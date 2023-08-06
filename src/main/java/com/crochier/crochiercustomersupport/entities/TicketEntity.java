package com.crochier.crochiercustomersupport.entities;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="Tickets")
public class TicketEntity implements Serializable {

    private static final long serialVersionID = 1L; // unique id for serializable
    private long id; // primary key
    private String customerName;
    private String ticketSubject;
    private String ticketBody;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    public String getTicketSubject() {
        return ticketSubject;
    }

    public void setTicketSubject(String ticketSubject) {
        this.ticketSubject = ticketSubject;
    }

    @Basic
    public String getTicketBody() {
        return ticketBody;
    }

    public void setTicketBody(String ticketBody) {
        this.ticketBody = ticketBody;
    }
}
