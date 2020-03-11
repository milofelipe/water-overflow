package com.milofelipe;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class WaterOverflowProblemSolverTest {

    @Test
    public void calculateVolumeOnRow3Glass2When2000mlPoured() {
        double glassVolumeInMl = 250;
        int row = 3;
        int glassNum = 2;
        double pouredLiquidVolumeInMl = 2000;

        WaterOverflowProblemSolver waterOverflowProblemSolver = new WaterOverflowProblemSolver(glassVolumeInMl);
        double volume = waterOverflowProblemSolver.calculate(row, glassNum, pouredLiquidVolumeInMl);

        assertTrue(218.75 == volume);
    }

    @Test
    public void calculateVolumeOnRow3Glass3When2000mlPoured() {
        double glassVolumeInMl = 250;
        int row = 3;
        int glassNum = 3;
        double pouredLiquidVolumeInMl = 2000;

        WaterOverflowProblemSolver waterOverflowProblemSolver = new WaterOverflowProblemSolver(glassVolumeInMl);
        double volume = waterOverflowProblemSolver.calculate(row, glassNum, pouredLiquidVolumeInMl);

        assertTrue(31.25 == volume);
    }

    @Test
    public void calculateVolumeOnRow4Glass3When2000mlPoured() {
        double glassVolumeInMl = 250;
        int row = 4;
        int glassNum = 3;
        double pouredLiquidVolumeInMl = 2000;

        WaterOverflowProblemSolver waterOverflowProblemSolver = new WaterOverflowProblemSolver(glassVolumeInMl);
        double volume = waterOverflowProblemSolver.calculate(row, glassNum, pouredLiquidVolumeInMl);

        assertTrue(0 == volume);
    }

    @Test
    public void calculateVolumeOnRow0Glass0When500mlPoured() {
        double glassVolumeInMl = 250;
        int row = 0;
        int glassNum = 0;
        double pouredLiquidVolumeInMl = 500;

        WaterOverflowProblemSolver waterOverflowProblemSolver = new WaterOverflowProblemSolver(glassVolumeInMl);
        double volume = waterOverflowProblemSolver.calculate(row, glassNum, pouredLiquidVolumeInMl);

        assertTrue(250 == volume);
    }

}
