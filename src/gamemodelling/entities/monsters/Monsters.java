package gamemodelling.entities.monsters;

import gamemodelling.abilities.Ability;
import gamemodelling.abilities.Focus;
import gamemodelling.abilities.monsters.Bite;
import gamemodelling.abilities.monsters.Block;
import gamemodelling.abilities.monsters.Claw;
import gamemodelling.abilities.monsters.Deflect;
import gamemodelling.abilities.monsters.MonsterFire;
import gamemodelling.abilities.monsters.MonsterIce;
import gamemodelling.abilities.monsters.MonsterLightning;
import gamemodelling.abilities.monsters.MonsterWater;
import gamemodelling.abilities.monsters.Scratch;
import gamemodelling.abilities.monsters.Smash;
import gamemodelling.abilities.runa.Fire;
import gamemodelling.abilities.runa.Ice;
import gamemodelling.abilities.runa.Water;
import gamemodelling.entities.Type;

import java.util.LinkedList;
import java.util.List;

public enum Monsters {
    //
    //Bosses
    //
    SPIDER_KING(1, true, 0, 50, Type.LIGHTNING,
            List.of(new Bite(1), new Block(1), new Focus(1), new MonsterLightning(1))),
    MEGA_SAURUS(2, true, 100, 0, Type.BASIC,
            List.of(new Bite(2), new Block(2), new Focus(2), new MonsterFire(1), new MonsterLightning(1))),
    //
    //Level 1 Monsters
    //
    FROG(1, false, 1, 16, Type.WATER,
            List.of(new Focus(1), new MonsterWater(1))),
    GHOST(1, false, 2, 15, Type.ICE,
            List.of(new Focus(1), new MonsterIce(1))),
    GORGON(1, false, 3, 13, Type.FIRE,
            List.of(new Focus(1), new MonsterFire(1))),
    SKELETON(1, false, 4, 14, Type.LIGHTNING,
            List.of(new Focus(1), new MonsterLightning(1))),
    SPIDER(1, false, 5, 15, Type.BASIC, List.of(new Bite(1), new Block(1))),
    GOBLIN(1, false, 6, 12, Type.BASIC, List.of(new Smash(1), new Deflect(1))),
    RAT(1, false, 7, 14, Type.BASIC, List.of(new Block(1), new Claw(1))),
    MUSHROOMLIN(1, false, 8, 20, Type.BASIC, List.of(new Deflect(1), new Scratch(1))),
    //
    //Level 2 Monsters
    //
    SNAKE(2, false, 1, 31, Type.ICE,
            List.of(new Bite(2), new Focus(2), new Ice(2))),
    DARK_ELF(2, false, 2, 34, Type.BASIC,
            List.of(new Focus(2), new MonsterWater(1), new MonsterLightning(1))),
    SHADOW_BLADE(2, false, 3, 27, Type.LIGHTNING,
            List.of(new Scratch(2), new Focus(2), new MonsterLightning(2))),
    HORNET(2, false, 4, 32, Type.FIRE,
            List.of(new Scratch(2), new Focus(2), new MonsterFire(1), new MonsterFire(2))),
    TARANTULA(2, false, 5, 33, Type.BASIC,
            List.of(new Bite(2), new Block(2), new Scratch(2))),
    BEAR(2, false, 6, 40, Type.BASIC,
            List.of(new Claw(2), new Deflect(2), new Block(2))),
    MUSHROOMLON(2, false, 7, 50, Type.BASIC,
            List.of(new Deflect(2), new Scratch(2), new Block(2))),
    WILD_BOAR(2, false, 8, 27, Type.BASIC,
            List.of(new Scratch(2), new Deflect(2), new Scratch(2)));

    final int level;
    final boolean boss;
    final Type type;
    final int id;
    final int maxHP;
    final List<Ability> abilities = new LinkedList<>();

    Monsters(int level, boolean boss, int id, int maxHP, Type type, List<Ability> abilities) {
        this.level = level;
        this.boss = boss;
        this.id = id;
        this.maxHP = maxHP;
        this.type = type;
        this.abilities.addAll(abilities);
    }

    @Override
    public String toString() {
        String[] lowerCaseParts = this.name().toLowerCase().split("_");
        StringBuilder output = new StringBuilder();
        for (String part : lowerCaseParts) {
            output.append(part.substring(0, 1).toUpperCase()).append(part.substring(1));
        }
        return output.toString();
    }
}
