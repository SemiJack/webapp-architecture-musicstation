package bada_project.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.inMemoryAuthentication()
            .withUser("user")
            .password("user")
            .roles(String.valueOf(Roles.USER))
            .and()
            .withUser("admin")
            .password("admin")
            .roles("ADMIN")
            .and()
            .withUser("KonradTworek")
            .password("kondzio")
            .roles("USER", "1")
            .and()
            .withUser("EwelinaKarolak")
            .password("ewka22")
            .roles("USER", "3")
            .and()
            .withUser("PiotrLepek")
            .password("pietru7")
            .roles("USER", "4")
            .and()
            .withUser("JanKowalski")
            .password("kowalJan")
            .roles("USER", "5");
}

@Bean
    public PasswordEncoder getPasswordEncoder() {return NoOpPasswordEncoder.getInstance();
}
@Override
    protected void configure(HttpSecurity http) throws Exception{
    http
            .authorizeRequests()
            .antMatchers("/","/index").permitAll()
            .antMatchers("/resources/static/**").permitAll()
            .antMatchers("/main").authenticated()
            .antMatchers("/main_admin").access("hasRole('ADMIN')")
            .antMatchers("/main_user").access("hasRole('USER')")
            .antMatchers("/employees").authenticated()
            .antMatchers("/employees/**").access("hasRole('ADMIN') OR hasRole('USER')")
            .antMatchers("/broadasts").authenticated()
            .antMatchers("/broadcasts/**").access("hasRole('ADMIN')")
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/main")
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/index")
            .logoutSuccessUrl("/index")
            .permitAll();
}
}
