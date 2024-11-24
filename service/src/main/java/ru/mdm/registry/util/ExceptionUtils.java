package ru.mdm.registry.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.mdm.registry.exception.ResponseStatusException;
import ru.mdm.registry.exception.ServerException;

import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtils {

    public static Function<Throwable, Throwable> extExceptionMapper(String message) {
        return throwable -> throwable instanceof ResponseStatusException ?
                throwable : new ServerException(message, throwable);
    }
}
