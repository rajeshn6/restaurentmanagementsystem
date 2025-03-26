package cts.rms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import cts.rms.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers(HttpMethod.POST,"/user-api/**").permitAll()
				//.requestMatchers(HttpMethod.GET,"/restaurent-api/**").hasAnyRole("USER","Admin")
				.requestMatchers("/restaurent-api/**").hasRole("ADMIN")
				.anyRequest().authenticated()).csrf(csrf -> csrf.disable())
				.cors(cors -> cors.disable())
				.httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				
				.logout(Customizer.withDefaults())
				;
			
		return http.build();
	}
//	@Bean
//	UserDetailsService userDetailsService() {
//			UserDetails user1=User.builder().username("rajesh").passwordEncoder(p->passwordEncoder().encode("rajesh123")).roles("ADMIN").build();
//			UserDetails user2=User.builder().username("ajay").passwordEncoder(p->passwordEncoder().encode("ajay123")).roles("USER").build();
//		return new InMemoryUserDetailsManager(user1,user2);
//	}
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
		
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
