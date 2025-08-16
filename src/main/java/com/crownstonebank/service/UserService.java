package com.crownstonebank.service;

import com.crownstonebank.dto.UserDTO;
import com.crownstonebank.entity.User;
import com.crownstonebank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User registerUser(UserDTO userDto) {
        // Logic to register a new user
        User user =mapToUser(userDto);

        return userRepository.save(user);

    }

    private User mapToUser(UserDTO userDto){
        return User.builder()
                .lastName(userDto.getLastName())
                .firstName(userDto.getFirstName())
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .tag("crownstone_"+userDto.getUsername())
                .dob(userDto.getDob())
                .roles(List.of("USER"))
                .build();
    }

    public Map<String, Object> authenticateUser(UserDTO userDto) {
        Map<String, Object> authObject = new HashMap<>();
        User user = (User)userDetailsService.loadUserByUsername(userDto.getUsername());
        if(user == null){
            throw new UsernameNotFoundException("Usr not found");
        }
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));

        authObject.put("token","Bearer ".concat(jwtService.generateToken(userDto.getUsername())));
        authObject.put("user", user);

        return null;
    }

}
