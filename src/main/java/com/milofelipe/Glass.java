package com.milofelipe;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Glass {

    private final Glass leftParentGlass;
    private final Glass rightParentGlass;
    private double capacityInMl;
    private double pouredLiquidVolumeInMl;
    private double volumeInMl;
    private double volumeOverflowInMl;

    @Builder
    private Glass(double capacityInMl, double pouredLiquidVolumeInMl, Glass leftParentGlass, Glass rightParentGlass) {
        this.capacityInMl = capacityInMl;
        this.pouredLiquidVolumeInMl = pouredLiquidVolumeInMl;
        this.leftParentGlass = leftParentGlass;
        this.rightParentGlass = rightParentGlass;

        calculateVolume();
    }

    private void calculateVolume() {
        calculateVolumeFromParentGlass(leftParentGlass);
        calculateVolumeFromParentGlass(rightParentGlass);
        calculateFinalVolumeAndOverflow();
    }

    private void calculateVolumeFromParentGlass(Glass parentGlass) {
        if (parentGlass != null) {
            pouredLiquidVolumeInMl = pouredLiquidVolumeInMl + (parentGlass.getVolumeOverflowInMl() / 2);
        }
    }

    private void calculateFinalVolumeAndOverflow() {
        if (pouredLiquidVolumeInMl <= capacityInMl) {
            volumeInMl = pouredLiquidVolumeInMl;
        } else {
            volumeInMl = capacityInMl;
            volumeOverflowInMl = pouredLiquidVolumeInMl - capacityInMl;
        }
    }

}
