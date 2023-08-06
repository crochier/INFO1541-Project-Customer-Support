// put in header comments

package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.Attachment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ticket implements Serializable {
    private long id;
    private String customerName;
    private String ticketSubject;
    private String ticketBody;

    private Map<String, Attachment> attachments = new LinkedHashMap<>();

    public Ticket()
    {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTicketSubject() {
        return ticketSubject;
    }

    public void setTicketSubject(String ticketSubject) {
        this.ticketSubject = ticketSubject;
    }

    public String getTicketBody() {
        return ticketBody;
    }

    public void setTicketBody(String ticketBody) {
        this.ticketBody = ticketBody;
    }

    public Map<String, Attachment> getAttachments() {
        return this.attachments;
    }

    public void setAttachments(Map<String, Attachment> attachments) {
        this.attachments = attachments;
    }

    public void addAttachment(String fileName, Attachment attachment)
    {
        this.attachments.put(fileName, attachment);
    }

    public int getNumberOfAttachments()
    {
        return this.attachments.size();
    }

    Attachment getOneAttachment(String attachmentID)
    {
        return attachments.get(attachmentID);
    }

    public ArrayList<Attachment> getAllAttachments()
    {
        ArrayList<Attachment> allAttachments = new ArrayList<>();
        for (Map.Entry<String, Attachment> attachment : attachments.entrySet())
        {
            allAttachments.add(attachment.getValue());
        }
        return allAttachments;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "CustomerName='" + customerName + '\'' +
                ", Subject='" + ticketSubject + '\'' +
                ", TicketBody='" + ticketBody + '\'' +
                ", Attachments=" + attachments +
                '}';
    }
}
