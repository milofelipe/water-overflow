package com.milofelipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaterOverflowProblemSolver {

    private double glassVolumeInMl;

    public WaterOverflowProblemSolver(double glassVolumeInMl) {
        this.glassVolumeInMl = glassVolumeInMl;
    }

    public double calculate(int row, int glassNum, double pouredLiquidVolumeInMl) {
        Map<Integer, List<Glass>> stackOfGlasses = new HashMap<>();

        for (int i = 0; i <= row; i++) {
            List<Glass> previousRow = stackOfGlasses.get(i - 1);
            List<Glass> currentRow = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                Glass.GlassBuilder glassBuilder = Glass.builder().capacityInMl(glassVolumeInMl);

                populateLeftAndRightParentGlasses(previousRow, glassBuilder, j);

                pourLiquidIfTopGlass(previousRow, glassBuilder, pouredLiquidVolumeInMl);

                Glass glass = glassBuilder.build();

                if (i == row && j == glassNum) {
                    return glass.getVolumeInMl();
                }

                currentRow.add(glass);
            }

            stackOfGlasses.put(i, currentRow);
        }

        return 0;
    }

    private void pourLiquidIfTopGlass(List<Glass> previousRow, Glass.GlassBuilder glassBuilder, double pouredLiquidVolumeInMl) {
        if (previousRow == null || previousRow.isEmpty()) {
            glassBuilder.pouredLiquidVolumeInMl(pouredLiquidVolumeInMl);
        }
    }

    private void populateLeftAndRightParentGlasses(List<Glass> previousRow, Glass.GlassBuilder glassBuilder, int index) {
        if (previousRow != null && !previousRow.isEmpty()) {
            if (index > 0) {
                glassBuilder.leftParentGlass(previousRow.get(index - 1));
            }

            if (index < previousRow.size()) {
                glassBuilder.rightParentGlass(previousRow.get(index));
            }
        }
    }

}
