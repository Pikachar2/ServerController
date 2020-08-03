package com.shockops.types;

/**
 * Used for passing around methods.
 *
 * Define the Return Value {@value R} <br>
 * Example: <br>
 * Instantiate: <br>
 * ZedFunction<MyObject> my0ParamMethod = My0ParamMethodClass::my0ParamMethodFromClass; <br>
 * To execute the method, just call myVar Execution: MyObject retVal = my0ParamMethod.apply(12L);
 *
 * @author zjcurtis
 *
 * @param <R>
 */
@FunctionalInterface
public interface MultiArgFunction<A> {
    @SuppressWarnings("unchecked")
    void apply(String line, A... a);
}
