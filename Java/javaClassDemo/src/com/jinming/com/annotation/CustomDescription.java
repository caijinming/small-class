package com.jinming.com.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(CustomDescriptions.class)

public @interface CustomDescription {
    String description() default "";
}
