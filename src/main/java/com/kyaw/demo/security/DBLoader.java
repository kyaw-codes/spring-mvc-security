package com.kyaw.demo.security;

import com.kyaw.demo.domain.Role;
import com.kyaw.demo.domain.User;
import com.kyaw.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DBLoader implements CommandLineRunner {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public DBLoader(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        Role userRole = new Role();
        userRole.setName("ROLE_USER");

        User adminUser = new User();
        adminUser.setEmail("kyaw@gmail.com");
        adminUser.setPassword(bCryptPasswordEncoder.encode("kyaw"));

        User userUser = new User();
        userUser.setEmail("thaw@gmail.com");
        userUser.setPassword(bCryptPasswordEncoder.encode("thaw"));

        adminUser.getRoleList().add(adminRole);
        adminUser.getRoleList().add(userRole);
        userUser.getRoleList().add(userRole);

        // userRepository.save(adminUser);
        // userRepository.save(userUser);
    }
}
