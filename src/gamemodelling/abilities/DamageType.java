package gamemodelling.abilities;

import gamemodelling.entities.Type;

public enum DamageType {
    PHYSICAL_BASE(),
    MAGICAL_BASE(),
    PHYSICAL(PHYSICAL_BASE),
    ANTI_FOCUS(PHYSICAL_BASE),
    WATER(MAGICAL_BASE, Type.LIGHTNING),
    ICE(MAGICAL_BASE, Type.WATER),
    FIRE(MAGICAL_BASE, Type.ICE),
    LIGHTNING(MAGICAL_BASE, Type.FIRE);


    private Type effective;
    private DamageType basicType;

    DamageType() {
    }
    DamageType(DamageType basic) {
        basicType = basic;
    }

    DamageType(DamageType basicType, Type effective) {
        this(basicType);
        this.effective = effective;
    }

    public Type getEffective() {
        return effective;
    }

    public DamageType getBasicType() {
        return basicType;
    }

    public String toString() {
        return this.basicType.name().toLowerCase();
    }
}
