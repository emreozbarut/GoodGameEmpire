package com.goodgame.empire.model;

import com.goodgame.empire.enums.UnitType;
import com.goodgame.empire.enums.UsageType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Soldier
{
    private int meleeAttackPower;
    private int meleeDefensePower;
    private int rangedDefensePower;
    private int lootingCapacity;
    private int recruitmentTPU;
    private int recruitmentCost;
    private Healing healing;

    public abstract String getUnitName();

    public abstract UnitType getUnitType();

    public abstract UsageType getUsageType();

    public abstract int getTravelSpeed();

    public abstract int getFoodConsumption();

    public abstract int getRequiredLevel();
}
