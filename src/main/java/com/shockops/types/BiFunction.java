package com.shockops.types;

/**
 * Used for passing around methods.
 *
 * Define the type of the TWO parameters of the method you are wanting to pass around. Define the
 * Return Value {@value R} <br>
 * Example: <br>
 * Instantiate: <br>
 * MonoFunction<Long, MyObject, MyObject2> my1ParamMethod =
 * My2ParamMethodClass::my2ParamMethodFromClass; <br>
 * To execute the method, just call myVar Execution: MyObject retVal = my2ParamMethod.apply(12L,
 * listOfString);
 *
 * @author zjcurtis
 *
 * @param <A>
 * @param <B>
 * @param <R>
 */
@FunctionalInterface
public interface BiFunction<A, B, R> {
    R apply(A a, B b);
}
