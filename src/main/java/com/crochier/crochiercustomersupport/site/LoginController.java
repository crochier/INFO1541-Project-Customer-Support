package com.crochier.crochiercustomersupport.site;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import java.util.Hashtable;
import java.util.Map;

@Controller
public class LoginController
{
   public static final Map<String, String> userDB = new Hashtable<>();
   static
   {
       userDB.put("christian", "admin123");
       userDB.put("john", "password123");
       userDB.put("suzie", "suzie123");
   }
   @RequestMapping("logout")
    public View logout(HttpSession session)
   {
       session.invalidate();
       return new RedirectView("login", true, false);
   }
   @GetMapping("login")
    public ModelAndView loginForm(Model model, HttpSession session)
   {
       if (session.getAttribute("username") != null)
       {
           return new ModelAndView(new RedirectView("/tickets/listTickets", true, false));
       }
       model.addAttribute("loginFailed", false);
       return new ModelAndView("login", "loginForm", new LoginForm());
   }
   @PostMapping("login")
   public ModelAndView loginCheck(@ModelAttribute("loginForm") LoginForm form,
                                  Model model,
                                  HttpSession session,
                                  HttpServletRequest request)
   {
       if (session.getAttribute("username") != null)
       {
           return new ModelAndView(new RedirectView("/tickets/listTickets", true, false));
       }
       String username = form.getUsername();
       String password = form.getPassword();
       if (username == null || password == null || !userDB.containsKey(username) ||
               !password.equals(userDB.get(username)))
       {
          model.addAttribute("loginFailed", true);
          model.addAttribute("loginForm", form);
          return new ModelAndView("login");
       }
       session.setAttribute("username", username);
       request.changeSessionId();
       return new ModelAndView(new RedirectView("/tickets/listTickets", true, false));
   }

   public static class LoginForm
   {
       public String getUsername() {
           return username;
       }

       public String getPassword() {
           return password;
       }

       public void setPassword(String password) {
           this.password = password;
       }

       private String username;
       private String password;
       public void setUsername(String username)
       {
           this.username = username;
       }
   }
}
