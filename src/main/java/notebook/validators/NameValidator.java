package notebook.validators;

import notebook.validators.annotations.NameInfo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<NameInfo, String> {

    private String pattern;
    @Override
    public void initialize(NameInfo contactInfo) {
        pattern = "^([a-zA-Zа-яА-Я]\\.?)+(([',. -]([a-zA-Zа-яА-Я ])\\.?)?([a-zA-Zа-яА-Я]\\.?)*)*$";
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.matches(pattern, s);
    }

}
