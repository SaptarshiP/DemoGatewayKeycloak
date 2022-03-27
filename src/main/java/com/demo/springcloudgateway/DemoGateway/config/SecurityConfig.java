package com.demo.springcloudgateway.DemoGateway.config;

//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
//import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
//import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
//@Import(KeycloakSpringBootConfigResolver.class)
public class SecurityConfig {//extends KeycloakWebSecurityConfigurerAdapter{
	
//	@Autowired
//	public void configureGloabl( AuthenticationManagerBuilder auth ) {
//		KeycloakAuthenticationProvider keyCloakAuthenticationProvider = keycloakAuthenticationProvider();  
//		keyCloakAuthenticationProvider.setGrantedAuthoritiesMapper( new SimpleAuthorityMapper() );
//		auth.authenticationProvider(keyCloakAuthenticationProvider);
//	}
//	
//	@Bean
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new RegisterSessionAuthenticationStrategy(buildSessionRegistry());
//    }
//
//    @Bean
//    protected SessionRegistry buildSessionRegistry() {
//        return new SessionRegistryImpl();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        super.configure(http);
//        http
//                .authorizeRequests()
//                .antMatchers("/app").hasRole("seller")
//                .anyRequest().permitAll();
//    }

	@Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		
        http
        		//.csrf().disable()
        		.cors().disable()
                //.authorizeExchange().anyExchange().authenticated()
        		.authorizeExchange()
                .pathMatchers("/applicationController").hasRole("ROLE_customer")
                 .and()
                 .oauth2Login(); 
                //.oauth2ResourceServer()
                //.jwt();
        return http.build();
    }
}
