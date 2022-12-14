package com.nissan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.config.JwtTokenUtil;
import com.nissan.model.JWTResponse;
import com.nissan.model.User;
import com.nissan.service.LoginService;

@CrossOrigin                   //helps to avoid (cors) error
@RestController
@RequestMapping("api/")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private LoginService userDetailsService;
	
	// authenticate
	    @PostMapping("userlogin")
	    public ResponseEntity<JWTResponse> createAuthenticationToken(@RequestBody User authenticationRequest)
	            throws Exception {



	       authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());



	// checking if user exist or not
	        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());



	// generating token
	        final String token = jwtTokenUtil.generateToken(userDetails);



	// getting user details
	        User user = userDetailsService.findByUserName(authenticationRequest.getUserName());



	// taking username and roleId
	        String userName = user.getUserName();
	        Integer roleId = user.getRole().getRoleId();



	       return new ResponseEntity<JWTResponse>(new JWTResponse(token, userName, roleId), HttpStatus.OK);
	    }



	// first time register
	    @RequestMapping(value = "register", method = RequestMethod.POST)
	    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
	        return ResponseEntity.ok(userDetailsService.save(user));
	    }



	   private void authenticate(String username, String password) throws Exception {
	        try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	        } catch (DisabledException e) {
	            throw new Exception("USER_DISABLED", e);
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }
	    }
	


}
