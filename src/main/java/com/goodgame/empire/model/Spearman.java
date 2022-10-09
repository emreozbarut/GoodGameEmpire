package com.goodgame.empire.model;

import com.goodgame.empire.enums.UnitType;
import com.goodgame.empire.enums.UsageType;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Spearman extends Soldier
{
    @Override
    public String getUnitName()
    {
        return "Spearman";
    }

    @Override
    public UnitType getUnitType()
    {
        return UnitType.MELEE;
    }

    @Override
    public UsageType getUsageType()
    {
        return UsageType.ATTACK;
    }

    @Override
    public int getTravelSpeed()
    {
        return 75;
    }

    @Override
    public int getFoodConsumption()
    {
        return 2;
    }

    @Override
    public int getRequiredLevel()
    {
        return 1;
    }
}
