package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.Attachment;

import java.util.Map;

public interface AttachmentRepository extends GenericRepository<String, Attachment>
{
    Map<String, Attachment> getByTicketId(Long ticketId);
}
