package com.mycompany.jakubMarioProject;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipValidator implements IValidator<String> {

    @Override
    public void validate(IValidatable<String> validatable) {
        String value = validatable.getValue();

        if (!containsOnlyNumebrs(value)) {
            error(validatable, "noOnlyNumbers", "Zip code should have only numbers");
            return;
        }

        if (value.length() != 5) {
            error(validatable, "lengthEx", "Zip code should have only 5 numbers, actual size: " + value.length());
            return;
        }
    }

    static boolean containsOnlyNumebrs(String value) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    private void error(IValidatable<String> validatable, String errorKey, String message) {
        ValidationError error = new ValidationError();
        error.setMessage(message);
        error.addKey(getClass().getSimpleName() + "." + errorKey);

        validatable.error(error);
    }
}