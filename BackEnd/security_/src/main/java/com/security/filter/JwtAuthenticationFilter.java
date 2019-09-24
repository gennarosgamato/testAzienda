package com.security.filter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.security.constants.SecurityConstants;
import com.security.model.Utente;
import com.security.service.IUserDetailsService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	private IUserDetailsService userService;
	
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
        	
        	Optional<Utente> user=userService.login(username, password);
        	if(!user.isEmpty()) {
        	 Authentication authenticationToken = new UsernamePasswordAuthenticationToken(user.get().getUsername(), user.get().getPassword());
        	 return authenticationManager.authenticate(authenticationToken);
        	}
        	 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null; 
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain filterChain, Authentication authentication) throws UnsupportedEncodingException {
        User user = ((User) authentication.getPrincipal());

        List<String> roles = user.getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());

        byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
                .setIssuer(SecurityConstants.TOKEN_ISSUER)
                .setAudience(SecurityConstants.TOKEN_AUDIENCE)
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 864000000))
                .claim("rol", roles)
                .compact();
        
//        String token = Jwts.builder()
//        		  .setSubject(user.getUsername())
//        		  .setExpiration(new Date(1300819380))
//        		  .setIssuer(SecurityConstants.TOKEN_ISSUER)
//        		  .setAudience(SecurityConstants.TOKEN_AUDIENCE)
//        		  .signWith(
//        		    SignatureAlgorithm.HS512,
//        		    signingKey.getBytes()
//        		  )
//        		  .compact();

        response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + token);
    }
}
