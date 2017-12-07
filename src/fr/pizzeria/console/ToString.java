/**
 * 
 */
package fr.pizzeria.console;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
/**
 * @author thien
 *
 */
public @interface ToString {

	boolean uppercase() default false;

	String symbol() default "";

	String surroundedBefore() default " ";

	String surroundedAfter() default " ";
}
