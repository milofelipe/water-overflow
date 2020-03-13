package com.milofelipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaterOverflow {

    private double glassVolumeInMl;

    public WaterOverflow(double glassVolumeInMl) {
        this.glassVolumeInMl = glassVolumeInMl;
    }

    public double calculate(int row, int glassNum, double pouredLiquidVolumeInMl) {
        Map<Integer, List<Glass>> stackOfGlasses = new HashMap<>();

        for (int rowIndex = 0; rowIndex <= row; rowIndex++) {
            List<Glass> previousRow = stackOfGlasses.get(rowIndex - 1);
            List<Glass> currentRow = new ArrayList<>();

            for (int glassIndex = 0; glassIndex <= rowIndex; glassIndex++) {
                Glass.GlassBuilder glassBuilder = Glass.builder().capacityInMl(glassVolumeInMl);
                populateLeftAndRightParentGlasses(previousRow, glassBuilder, glassIndex);
                pourLiquidIfTopGlass(previousRow, glassBuilder, pouredLiquidVolumeInMl);

                Glass glass = glassBuilder.build();

                if ((rowIndex == row) && (glassIndex == glassNum)) {
                    return glass.getVolumeInMl();
                }

                currentRow.add(glass);
            }

            stackOfGlasses.put(rowIndex, currentRow);
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
