package WS.BLG.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableWebSecurity
//@EnableJpaRepositories
//@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Value("${security.ignoredCode}")
    private String securityCode;

//    @Autowired
//    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web)
            throws Exception {
        RequestHeaderRequestMatcher headerMatcher = new RequestHeaderRequestMatcher("Ignored-Security-Code", "securityCode" );
        web.ignoring().requestMatchers(headerMatcher);
        web.ignoring().antMatchers("/token-username");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().exceptionHandling()
//                .authenticationEntryPoint(customAuthenticationEntryPoint)
//                .authenticationEntryPoint(new OAuth2AuthenticationEntryPoint())
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint())
                .and().authorizeRequests()
                .antMatchers("/oauth/token").permitAll()
                .antMatchers("/oauth/check_token").permitAll()
                .anyRequest().authenticated();

    }

//    @Bean
//    public AuditorAware<TblUserEntity> auditorAware() {
//        return new AuditorAwareImpl();
//    }

}
