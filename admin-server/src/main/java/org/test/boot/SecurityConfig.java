package org.test.boot;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		SavedRequestAwareAuthenticationSuccessHandler successHandler
//				= new SavedRequestAwareAuthenticationSuccessHandler();
//		successHandler.setTargetUrlParameter("redirectTo");
//		successHandler.setDefaultTargetUrl("/");
//
//		http.authorizeRequests()
//				.antMatchers("/assets/**").permitAll()
//				.antMatchers("/login").permitAll()
//				.anyRequest().authenticated().and()
//				.formLogin().loginPage("/login")
//				.successHandler(successHandler).and()
//				.logout().logoutUrl("/logout").and()
//				.httpBasic().and()
//				.csrf()
//				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//				.ignoringAntMatchers(
//						"/instances",
//						"/actuator/**"
//				);
//	}

	private final String adminContextPath;

	public SecurityConfig(AdminServerProperties adminServerProperties) {
		this.adminContextPath = adminServerProperties.getContextPath();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setTargetUrlParameter("redirectTo");

		http.authorizeRequests()
				.antMatchers(adminContextPath + "/assets/**").permitAll()
				.antMatchers(adminContextPath + "/login").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
				.logout().logoutUrl(adminContextPath + "/logout").and()
				.httpBasic().and()
				.csrf().disable();
		// @formatter:on
	}
}
