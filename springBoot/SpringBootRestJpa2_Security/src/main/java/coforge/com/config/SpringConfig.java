package coforge.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Map;

import static org.springframework.core.NestedExceptionUtils.buildMessage;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SpringConfig {

    @Bean
    public UserDetailsService getUserDetail() {
        InMemoryUserDetailsManager userDetail = new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("shyamkumar").password("abcdef").authorities("read").build();
        userDetail.createUser(user);
        return userDetail;
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
//    @Bean
//    public PasswordEncoder getEncoder() {
//        return new BCryptPasswordEncoder();
//    }
Map<String,String> map;

    /*
    @Bean
    public SecurityFilterChain filterChain(MvcRequestMatcher.Builder mvc, HttpSecurity http) throws Exception {
        try {
            http
                    .csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers(mvc.pattern(AUTH_WHITELIST)).permitAll()
                            .anyRequest().authenticated()
                    )
                    .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                    .httpBasic(AbstractHttpConfigurer::disable) // disables pop-up
                    .formLogin(AbstractHttpConfigurer::disable)
                    .headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer
                            .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)) // to make accessible h2 console, disables xframe deny warnings
                    .cors(); // uses cors settings - only disabled if WebConfigLocal running
            return http.build();
        } catch (Exception ex) {
            throw new GenericRuntimeException(buildMessage(ERROR_WEB_SECURITY_FILTER.getText(ex.getMessage())), ex);
        }
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("filter called  1 ");
        try {
            http
                    .csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/*","/allPerson").permitAll()
                            .anyRequest().authenticated()
                    )
                    .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                    .httpBasic(AbstractHttpConfigurer::disable) // disables pop-up
                    .formLogin(AbstractHttpConfigurer::disable)
                    .headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer
                            .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)) // to make accessible h2 console, disables xframe deny warnings
                    .cors(Customizer.withDefaults()); // uses cors settings - only disabled if WebConfigLocal running
            System.out.println("filter called  2 "+http);
            return http.build();
        } catch (Exception ex) {
//            throw new GenericRuntimeException(buildMessage(ERROR_WEB_SECURITY_FILTER.getText(ex.getMessage())), ex);
          throw   ex;
        }

    }
    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                        //.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        //.requestMatchers().permitAll()
                        .requestMatchers("/*","/allPerson").permitAll()
                        //.requestMatchers("/allPerson").denyAll()
                        .anyRequest().authenticated())
                //.httpBasic(Customizer.withDefaults());
                .formLogin(Customizer.withDefaults());
        return http.build();
    }*/

/*
    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
        //http.csrf(AbstractHttpConfigurer::disable).cors(Customizer.withDefaults()).authorizeHttpRequests()
        //return	 http.csrf().disable().authorizeHttpRequests().requestMatchers("/auth/welcome").permitAll()
        //return	 http.authorizeHttpRequests().requestMatchers("/auth/welcome").permitAll()
//		.and().authorizeHttpRequests().requestMatchers("/hello").authenticated().and().httpBasic().and().build();
        //.and().authorizeHttpRequests().requestMatchers("/allPerson").authenticated().and().formLogin().and().build();
        return http.authorizeHttpRequests().requestMatchers("/allPerson").authenticated().and().formLogin().and().build();
    }*/
}

/*
 @Configuration
 @EnableWebSecurity
 public class AuthorizeUrlsSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeHttpRequests()
                                .requestMatchers("/**").hasRole("USER")
                                .and()
                        .formLogin();
                return http. build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User. withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
                UserDetails admin = User. withDefaultPasswordEncoder()
                        .username("admin")
                        .password("password")
                        .roles("ADMIN", "USER")
                        .build();
                return new InMemoryUserDetailsManager(user, admin);
        }
 }

 */
































































































