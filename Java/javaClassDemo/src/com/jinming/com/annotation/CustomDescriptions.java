package com.jinming.com.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited

public @interface CustomDescriptions {
    CustomDescription[] value();
}
