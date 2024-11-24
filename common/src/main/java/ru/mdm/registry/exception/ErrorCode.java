package ru.mdm.registry.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    CANNOT_REGISTER_SERVICE("Не удалось зарегистрировать экземпляр сервиса");

    private final String text;

    public String buildErrorText(Object... params) {
        return String.format(this.getText(), params);
    }
}
