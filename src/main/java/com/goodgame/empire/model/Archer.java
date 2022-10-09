package com.goodgame.empire.model;

import com.goodgame.empire.enums.UnitType;
import com.goodgame.empire.enums.UsageType;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Archer extends Soldier
{
    @Override
    public String getUnitName()
    {
        return "Archer";
    }

    @Override
    public UnitType getUnitType()
    {
        return UnitType.RANGED;
    }

    @Override
    public UsageType getUsageType()
    {
        return UsageType.DEFENSE;
    }

    @Override
    public int getTravelSpeed()
    {
        return 25;
    }

    @Override
    public int getFoodConsumption()
    {
        return 2;
    }

    @Override
    public int getRequiredLevel()
    {
        return 3;
    }
}
