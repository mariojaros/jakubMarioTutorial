package com.mycompany.jakubMarioProject;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirtDateValidator implements IValidator<String> {
    private static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    @Override
    public void validate(IValidatable<String> validatable) {
        String value = validatable.getValue();

        Date date = null;
        try {
            date = dateFormat.parse(value);
        } catch (ParseException e) {
            error(validatable, "ParseException", "Parse / illegal exception: " + value);
            return;
        }

        Date now = new Date();

        if (now.compareTo(date) < 0) {
            error(validatable, "youCantBornInFuture", "you cant born in future: " + dateFormat.format(date) + ", now is: " + dateFormat.format(now));
            return;
        }
    }

    private void error(IValidatable<String> validatable, String errorKey, String message) {
        ValidationError error = new ValidationError();
        error.setMessage(message);
        error.addKey(getClass().getSimpleName() + "." + errorKey);

        validatable.error(error);
    }
}