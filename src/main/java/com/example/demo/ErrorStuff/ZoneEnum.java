package com.example.demo.ErrorStuff;

public enum ZoneEnum {
    AMERICA_SAO_PAULO("America/Sao_Paulo"),
    AMERICA_SAO_PAULO_SHORT("BET");

    private final String value;

    ZoneEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ZoneEnum parse(String value) {
        if (value == null) {
            return null;
        }
        for (ZoneEnum e : ZoneEnum.values()) {
            if (e.getValue().equalsIgnoreCase(value)) {
                return e;
            }
        }
        throw new AssertionError(value);
    }
}
