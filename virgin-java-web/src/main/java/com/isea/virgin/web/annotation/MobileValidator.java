package com.isea.virgin.web.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/7 15:25
 * @target:
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {
    /**
     * 手机号的正则表达式.
     */
    private static Pattern pattern = Pattern.compile(
            "^0?(13[0-9]|14[0-9]|15[0-9]|16[0-9]|17[0-9]|18[0-9]|19[0-9])[0-9]{8}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Matcher m = pattern.matcher(value);
        return m.matches();
    }

    @Override
    public void initialize(Mobile constraintAnnotation) {}
}
