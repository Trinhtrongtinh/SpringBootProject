package com.js.cloneproject.configuration;

import com.js.cloneproject.entity.Role;
import com.js.cloneproject.entity.User;
import com.js.cloneproject.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {
    private PasswordEncoder passwordEncoder;
    @Bean
    ApplicationRunner ApplicationRunner(UserRepository userRepository) {
        return args -> {
            if(userRepository.findByUsername("admin").isEmpty()) {
                Role role = new Role();
                role.setName("ADMIN");
                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
//                        .roles(role)
                        .build();
                userRepository.save(user);
                log.warn("User has been created with default password: admin, please change it");
            }

        };
    }
}
