package project_webtech.satu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class security extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // public pages
                .antMatchers(
                        HttpMethod.GET,
                        endpoints.SLASH
                ).permitAll()
                // static resources
                .antMatchers(
                        "/css/**",
                        "/images/**",
                        "/javascript/**"
                ).permitAll()
                .anyRequest().authenticated()

                // send the user back to the root page when logout
                .and()
                .logout().logoutSuccessUrl(endpoints.SLASH)

                .and()
                .oauth2Client()
                .and()
                .oauth2Login()
                .and().csrf().disable();
    }
}
