package ru.yudin.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value(); // from annotation
    }

    @Override
    // code is that user enter to a field
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        Boolean result;

        if (code != null)
            result = code.startsWith(coursePrefix);
        else
            result = true;

        return result;
    }
}
