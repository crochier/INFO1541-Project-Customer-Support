package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.Attachment;
import org.springframework.stereotype.Repository;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Repository
public class DefaultAttachmentRepository extends GenericJpaRepository<String, Attachment> implements
        AttachmentRepository {

    @Override
    public Map<String, Attachment> getByTicketId(Long ticketId) {
        try {
            Map<String, Attachment> attachments = new Hashtable<>();
            List<Attachment> attachmentList = this.entityManager.createQuery("SELECT a FROM Attachment a " +
                            "WHERE a.ticketId = :id",
                    Attachment.class).setParameter("id", ticketId).getResultList();
            for (Attachment a : attachmentList) {
                attachments.put(a.getName(), a);
            return attachments;
            }
        }
        catch (Exception e) {
            return null;
        }
        return null;
    }
}
