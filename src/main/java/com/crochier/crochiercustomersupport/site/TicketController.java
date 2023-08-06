package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.Attachment;
import jakarta.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
@RequestMapping("tickets")
public class TicketController {
    // private volatile int ticketID = 1;
    // private final Map<Integer, Ticket> allTickets = new LinkedHashMap<>();

    @Inject TicketService ticketService;

    @RequestMapping(value = {"listTickets", ""})
    public String listTickets(Model model) {
        model.addAttribute("allTickets", ticketService.getAllTickets());
        return "listTickets";
    }

    @GetMapping("create")
    public ModelAndView createTicket() {
        return new ModelAndView("ticketForm",
                "ticket", new TicketForm());
    }


    @PostMapping("create")
    public View createTicket(@ModelAttribute("tickets") TicketForm form) throws IOException {
        Ticket ticket = new Ticket();
        ticket.setCustomerName(form.getCustomerName());
        ticket.setTicketSubject(form.getTicketSubject());
        ticket.setTicketBody(form.getTicketBody());
        MultipartFile file = form.getAttachments();
        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setContents(file.getBytes());
        if (attachment.getName() != null && attachment.getName().length() > 0
                || (attachment.getContents() != null && attachment.getContents().length > 0))
        {
            ticket.addAttachment(attachment.getName(), attachment);
        }
//
        ticketService.save(ticket);
        return new RedirectView("view/" + ticket.getId(), true, false);
    }

    @GetMapping("view/{ticketID}")
    public ModelAndView viewTicket(Model model, @PathVariable("ticketID")int ticketID) {
        Ticket ticket = ticketService.getTicket(ticketID);

        if (ticket == null) {
            return new ModelAndView(new RedirectView("listTickets", true, false));
        }
        model.addAttribute("ticketID", ticketID);
        model.addAttribute("ticket", ticket);
        return new ModelAndView("viewTicket");
    }

    @GetMapping("/{ticketID}/attachment/{attachment:.+}")
    public View downloadAttachment(@PathVariable("ticketID")int ticketID, @PathVariable("attachment")String name) {
        Ticket ticket = ticketService.getTicket(ticketID);

        if (ticket == null)
        {
            return new RedirectView("listTickets", true, false);
        }
        Attachment attachment = ticket.getOneAttachment(name);
        if (attachment == null) {
            return new RedirectView("listTickets", true, false);
        }
        return new DownloadAttachment(attachment.getName(), attachment.getContents());
    }

    public static class TicketForm {
        private String customerName;
        private String ticketSubject;
        private String ticketBody;
        private MultipartFile attachments;

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

        public MultipartFile getAttachments() {
            return attachments;
        }

        public void setAttachments(MultipartFile attachments) {
            this.attachments = attachments;
        }
    }

}

