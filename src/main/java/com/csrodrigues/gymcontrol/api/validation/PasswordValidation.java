package com.csrodrigues.gymcontrol.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;
import java.util.Arrays;

public class PasswordValidation implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return true; // Deixa o @NotBlank cuidar de valores nulos/vazios
        }

        // Criamos a lista de regras escritas de forma elegante e legível
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(6, 30),             // No mínimo 6 e no máximo 30 caracteres
                new CharacterRule(EnglishCharacterData.Alphabetical, 1), // Pelo menos 1 letra
                new CharacterRule(EnglishCharacterData.Digit, 1),        // Pelo menos 1 número
                new CharacterRule(EnglishCharacterData.Special, 1)       // Pelo menos 1 caractere especial
        ));

        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid()) {
            return true;
        }

        // Se a senha falhar, nós customizamos a mensagem dinâmica com o que falhou
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
                "Password must be at least 6 characters long and contain at least one letter, one digit, and one special character."
        ).addConstraintViolation();

        return false;
    }
}
