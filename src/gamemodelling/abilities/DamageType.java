package gamemodelling.abilities;

import gamemodelling.monsters.Type;

public enum DamageType {
    BASIC_PHYSICAL("physical"),
    ANTI_FOCUS("physical"),
    BASIC_MAGICAL("magical"),
    WATER("magical", Type.LIGHTNING),
    ICE("magical", Type.WATER),
    FIRE("magical", Type.ICE),
    LIGHTNING("magical", Type.FIRE);

    private String basicType;
    private Type effective;

    DamageType(String basicType) {
        this.basicType = basicType;
    }

    DamageType(String basicType, Type effective) {
        this(basicType);
        this.effective = effective;
    }

    public Type getEffective() {
        return effective;
    }

    public String getBasicType() {
        return basicType;
    }
}
