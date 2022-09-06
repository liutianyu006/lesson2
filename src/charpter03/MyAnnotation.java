package charpter03;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.CLASS)
@Documented
@Inherited
public @interface MyAnnotation {
    String value();
//    String value() default "hello";
}
