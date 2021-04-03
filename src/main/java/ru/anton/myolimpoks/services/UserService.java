package ru.anton.myolimpoks.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.anton.myolimpoks.entity.User;
import ru.anton.myolimpoks.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
