package com.crochier.crochiercustomersupport.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionListController {
    @RequestMapping(value={"sessions", "session"})
    public String listSessions(Model model) {
        model.addAttribute("now", System.currentTimeMillis());
        model.addAttribute("numSessions", SessionListUtility.getNumberOfSessions() );
        model.addAttribute("sessions", SessionListUtility.getAllSessions());
        return "sessions";
    }
}
