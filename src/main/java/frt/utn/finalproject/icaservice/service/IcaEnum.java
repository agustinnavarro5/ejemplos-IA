package frt.utn.finalproject.icaservice.service;

import java.util.HashMap;
import java.util.Map;

public enum IcaEnum {

    ICA("ica", 0, 100),
    WATER_TEMP("water_temperature", 0, 50),
    DEATH_FISH_PROBABILITY("probability", 0, 100);

    private static final Map<String, IcaEnum> BY_LABEL = new HashMap<>();
    public final String label;
    public final Integer lowLimit;
    public final Integer highLimit;

    static {
        for (IcaEnum e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    private IcaEnum(final String label, final Integer lowLimit, final Integer highLimit) {
        this.label = label;
        this.lowLimit = lowLimit;
        this.highLimit = highLimit;
    }

    public static IcaEnum valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
