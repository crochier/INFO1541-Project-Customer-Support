package com.crochier.crochiercustomersupport.site;

import com.crochier.crochiercustomersupport.entities.UserPrincipal;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Hashtable;
import java.util.Map;

@Controller
public class LoginController {
    public static final Map<String, String> userDB = new Hashtable<>();
    static {
        userDB.put("Christian", "admin123");
        userDB.put("John", "password123");
        userDB.put("Susie", "greenmountains");
    }

    @Inject AuthenticationService authenticationService;

    @RequestMapping("logout")
    public View logout(HttpSession session) {
        session.invalidate();
        return new RedirectView("login", true, false);
    }

    @GetMapping("login")
    public ModelAndView loginForm(Model model, HttpSession session) {
        if (UserPrincipal.getPrincipal(session) != null) {
            return new ModelAndView(new RedirectView("/tickets/listTickets", true, false));
        }
        model.addAttribute("loginFailed", false);
        return new ModelAndView("login", "loginForm", new LoginForm());
    }

    @PostMapping("login")
    public ModelAndView loginCheck(@ModelAttribute("loginForm")LoginForm form,
                                   Model model,
                                   HttpSession session,
                                   HttpServletRequest request) {
        // already logged in
        if (UserPrincipal.getPrincipal(session) != null) {
            return new ModelAndView(new RedirectView("/tickets/listTickets", true, false));
        }

        Principal principal;
        try {
            principal = authenticationService.authenticate(form.getUsername(), form.getPassword());
        }
        catch (ConstraintViolationException e) {
            return new ModelAndView("login");
        }
        if (principal == null) {
            form.setPassword(null);
            model.addAttribute("loginFailed", true);
            model.addAttribute("loginForm", form);
            return new ModelAndView("login");
        }


        // we are logged in successfully
        UserPrincipal.setPrincipal(session, principal);
        request.changeSessionId();
        return new ModelAndView(new RedirectView("/tickets/listTickets", true, false));

    }

    public static class LoginForm {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
