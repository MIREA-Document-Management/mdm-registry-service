package ru.mdm.registry.event;

import ru.mdm.kafka.model.Event;
import ru.mdm.registry.model.InstanceDto;

public class RegisterServiceEventSuccess extends Event<InstanceDto> {

    public static final String EVENT_TYPE = "mdm-registry-service.RegisterServiceEvent.Success";

    public RegisterServiceEventSuccess() {
        super(EVENT_TYPE);
    }

    public RegisterServiceEventSuccess(InstanceDto data) {
        super(EVENT_TYPE, data);
    }

    public static RegisterServiceEventSuccess of() {
        return new RegisterServiceEventSuccess();
    }

    public static RegisterServiceEventSuccess of(InstanceDto data) {
        return new RegisterServiceEventSuccess(data);
    }
}
