package com.milofelipe;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WaterOverflowTest {

    @Test
    public void calculateVolumeOnRow3Glass2When2000mlPoured() {
        double glassVolumeInMl = 250;
        int row = 3;
        int glassNum = 2;
        double pouredLiquidVolumeInMl = 2000;

        WaterOverflow waterOverflow = new WaterOverflow(glassVolumeInMl);
        double volume = waterOverflow.calculate(row, glassNum, pouredLiquidVolumeInMl);

        assertEquals(218.75, volume);
    }

    @Test
    public void calculateVolumeOnRow3Glass3When2000mlPoured() {
        double glassVolumeInMl = 250;
        int row = 3;
        int glassNum = 3;
        double pouredLiquidVolumeInMl = 2000;

        WaterOverflow waterOverflow = new WaterOverflow(glassVolumeInMl);
        double volume = waterOverflow.calculate(row, glassNum, pouredLiquidVolumeInMl);

        assertEquals(31.25, volume);
    }

    @Test
    public void calculateVolumeOnRow4Glass3When2000mlPoured() {
        double glassVolumeInMl = 250;
        int row = 4;
        int glassNum = 3;
        double pouredLiquidVolumeInMl = 2000;

        WaterOverflow waterOverflow = new WaterOverflow(glassVolumeInMl);
        double volume = waterOverflow.calculate(row, glassNum, pouredLiquidVolumeInMl);

        assertEquals(0.0, volume);
    }

    @Test
    public void calculateVolumeOnRow0Glass0When500mlPoured() {
        double glassVolumeInMl = 250;
        int row = 0;
        int glassNum = 0;
        double pouredLiquidVolumeInMl = 500;

        WaterOverflow waterOverflow = new WaterOverflow(glassVolumeInMl);
        double volume = waterOverflow.calculate(row, glassNum, pouredLiquidVolumeInMl);

        assertEquals(250.0, volume);
    }

}
