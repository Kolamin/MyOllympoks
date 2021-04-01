package ru.anton.myolimpoks.services;

import ru.anton.myolimpoks.entity.User;
import ru.anton.myolimpoks.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
}
