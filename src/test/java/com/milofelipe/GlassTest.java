package com.milofelipe;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GlassTest {

    @Test
    public void calculateVolumeWithNoOverflow() {
        Glass leftParent = Glass.builder().capacityInMl(250).pouredLiquidVolumeInMl(300).build();
        Glass rightParent = Glass.builder().capacityInMl(250).pouredLiquidVolumeInMl(300).build();

        Glass glassToTest = Glass.builder().capacityInMl(250)
                .leftParentGlass(leftParent).rightParentGlass(rightParent).build();

        assertEquals(50.0, glassToTest.getVolumeInMl());
        assertEquals(0.0, glassToTest.getVolumeOverflowInMl());
    }

    @Test
    public void calculateVolumeWithOverflow() {
        Glass leftParent = Glass.builder().capacityInMl(250).pouredLiquidVolumeInMl(600).build();
        Glass rightParent = Glass.builder().capacityInMl(250).pouredLiquidVolumeInMl(600).build();

        Glass glassToTest = Glass.builder().capacityInMl(250)
                .leftParentGlass(leftParent).rightParentGlass(rightParent).build();

        assertEquals(250.0, glassToTest.getVolumeInMl());
        assertEquals(100.0, glassToTest.getVolumeOverflowInMl());
    }

    @Test
    public void calculateVolumeOfZeroCapacityGlass() {
        Glass leftParent = Glass.builder().capacityInMl(250).pouredLiquidVolumeInMl(600).build();
        Glass rightParent = Glass.builder().capacityInMl(250).pouredLiquidVolumeInMl(600).build();

        Glass glassToTest = Glass.builder().leftParentGlass(leftParent).rightParentGlass(rightParent).build();

        assertEquals(0.0, glassToTest.getVolumeInMl());
        assertEquals(350.0, glassToTest.getVolumeOverflowInMl());
    }

}