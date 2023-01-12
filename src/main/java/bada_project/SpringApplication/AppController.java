package bada_project.SpringApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/audycje").setViewName("table/audycje");
        registry.addViewController("/adresy").setViewName("table/adresy");
        registry.addViewController("/autorzy").setViewName("table/autorzy");
        registry.addViewController("/gatunki").setViewName("table/gatunki");
        registry.addViewController("/goscie").setViewName("table/goscie");
        registry.addViewController("/nagrania").setViewName("table/nagrania");
        registry.addViewController("/pracownicy").setViewName("table/pracownicy");
        registry.addViewController("/reklamy").setViewName("table/reklamy");
        registry.addViewController("/reklamodawcy").setViewName("table/reklamodawcy");
        registry.addViewController("/reporterzy").setViewName("table/reporterzy");
        registry.addViewController("/rozglosnie").setViewName("table/rozglosnie");
        registry.addViewController("/sprzety").setViewName("table/sprzety");
        registry.addViewController("/stanowiska").setViewName("table/stanowiska");
        registry.addViewController("/utwory").setViewName("table/utwory");
        registry.addViewController("/wlasciciele").setViewName("table/wlasciciele");


    }

    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            } else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            } else {
                return "redirect:/index";
            }
        }
    }

    @RequestMapping(value = {"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }

    @RequestMapping(value = {"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }



}
