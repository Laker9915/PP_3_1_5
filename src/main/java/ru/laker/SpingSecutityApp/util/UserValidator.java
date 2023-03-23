package ru.laker.SpingSecutityApp.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.laker.SpingSecutityApp.models.User;
import ru.laker.SpingSecutityApp.services.UserService;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if(userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "", "This email is already taken");
        }
    }
}
