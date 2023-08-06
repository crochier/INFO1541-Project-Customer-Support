package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.Attachment;
import com.crochier.crochiercustomersupport.entities.TicketEntity;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class DefaultTicketService implements TicketService{
    @Inject TicketRepository ticketRepo;
    @Inject AttachmentRepository attachmentRepo;
    @Override
    @Transactional
    public List<Ticket> getAllTickets() {
        List<Ticket> list = new ArrayList<>();
        ticketRepo.getAll().forEach(e -> list.add((this.convert(e))));
        return list;
    }

    @Override
    public Ticket getTicket(long id) {
        TicketEntity entity = ticketRepo.get(id);

        return entity == null ? null : this.convert(entity);
    }

    private Ticket convert(TicketEntity entity) {
        Ticket ticket = new Ticket();
        ticket.setId(entity.getId());
        ticket.setCustomerName(entity.getCustomerName());
        ticket.setTicketSubject(entity.getTicketSubject());
        ticket.setTicketBody(entity.getTicketBody());
        Map<String, Attachment> attachmentMap = attachmentRepo.getByTicketId(entity.getId());
        if (attachmentMap != null) {

            ticket.setAttachments(attachmentMap);
        }

        return ticket;
    }

    // private Map<String, Attachment> convertToMap(List)
    @Override
    @Transactional
    public void save(Ticket ticket) {
        // convert from Ticket to TicketEntity
        TicketEntity entity = new TicketEntity();
        entity.setId(ticket.getId());

        entity.setCustomerName(ticket.getCustomerName());
        entity.setTicketSubject(ticket.getTicketSubject());
        entity.setTicketBody(ticket.getTicketBody());
        if (ticket.getId() < 1) {
            ticketRepo.add(entity);

            ticket.setId(entity.getId());

            if (ticket.getNumberOfAttachments() > 0) {

                for (Attachment attachment : ticket.getAllAttachments()) {
                    attachment.setTicketId(ticket.getId());
                    attachmentRepo.add(attachment);
                }
            }
            else {
                ticketRepo.update(entity);
            }
        }
    }

    @Override
    @Transactional
    public void delete(long id) {
        ticketRepo.deleteById(id);
    }
}
