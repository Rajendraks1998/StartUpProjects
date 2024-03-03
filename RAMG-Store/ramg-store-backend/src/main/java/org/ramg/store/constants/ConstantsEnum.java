package org.ramg.store.constants;

import lombok.Getter;

@Getter
public enum ConstantsEnum {

    USER_NOT_EXISTS("User Not exists with the given Id: ");

    private final String value;

    ConstantsEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
