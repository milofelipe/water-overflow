package com.milofelipe;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Glass {
    private double capacityInMl;
    private double pouredLiquidVolumeInMl;
    private Glass leftParentGlass;
    private Glass rightParentGlass;
    private double volumeInMl;
    private double volumeOverflowInMl;

    @Builder
    public Glass(double capacityInMl, double pouredLiquidVolumeInMl, Glass leftParentGlass, Glass rightParentGlass) {
        this.capacityInMl = capacityInMl;
        this.pouredLiquidVolumeInMl = pouredLiquidVolumeInMl;
        this.leftParentGlass = leftParentGlass;
        this.rightParentGlass = rightParentGlass;

        calculateVolume();
    }

    private void calculateVolume() {
        if (leftParentGlass != null) {
            pouredLiquidVolumeInMl = pouredLiquidVolumeInMl + (leftParentGlass.getVolumeOverflowInMl() / 2);
        }

        if (rightParentGlass != null) {
            pouredLiquidVolumeInMl = pouredLiquidVolumeInMl + (rightParentGlass.getVolumeOverflowInMl() / 2);
        }

        if (pouredLiquidVolumeInMl <= capacityInMl) {
            volumeInMl = pouredLiquidVolumeInMl;
        } else {
            volumeInMl = capacityInMl;
            volumeOverflowInMl = pouredLiquidVolumeInMl - capacityInMl;
        }
    }

}
