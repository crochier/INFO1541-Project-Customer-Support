package com.crochier.crochiercustomersupport.entities;


import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="Attachments")
public class Attachment implements Serializable {
    private static final long serialVersionId = 1l;
    private long id;
    private long ticketId;
    private String name;
    private byte[] contents;

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
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    @Lob
    public byte[] getContents()
    {
        return contents;
    }

    public void setContents(byte[] contents)
    {
        this.contents = contents;
    }

}
