package com.mobiquityinc.reader;

import java.util.function.Function;

import com.mobiquityinc.exception.APIException;

@FunctionalInterface
public interface ThrowingInputReaderException<T, R, E extends Throwable>  {
	R apply(T t) throws E;
	
	static <T, R, E extends APIException> Function<T,R> wrap(ThrowingInputReaderException<T,R,E> f) {
		return t-> {
			try {
				return f.apply(t);
			} catch (APIException e) {
				throw new RuntimeException("Error", e);
			}
		};
	}
	

}
