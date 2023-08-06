package com.crochier.crochiercustomersupport.entities;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "Attachments")
public class Attachment implements Serializable {
    private static final long serialVersionId = 1L;
    private long id;
    private long ticketId;
    private String name;
    private byte[] contents;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Attachment() {
    }
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Lob
    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }
}
