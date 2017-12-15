package notebook.validators;

import com.sun.corba.se.pept.transport.ContactInfo;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator extends ConstraintValidator<ContactInfo, String> {

    @Value("${contactInfoType}")
    private String expressionType;

    private String pattern;
    @Override
    public void initialize(ContactInfo contactInfo) {
        if (StringUtils.isEmptyOrWhitespace(expressionType)) {
            LOG.error("Contact info type missing!");
        } else {
            pattern = expressionRepository.findOne(expressionType)
                    .map(ContactInfoExpression::getPattern).get();
        }
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
