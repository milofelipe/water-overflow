package com.milofelipe;

public class WaterOverflowCalculator {

    public static void main(String[] args) {
        validateArguments(args);

        int row = Integer.parseInt(args[0]);
        int glassNum = Integer.parseInt(args[1]);
        double pouredVolumeInMl = Double.parseDouble(args[2]);
        double glassCapacityInMl = 250;

        if (args.length == 4) {
            glassCapacityInMl = Double.parseDouble(args[3]);
        }

        WaterOverflow waterOverflow = new WaterOverflow(glassCapacityInMl);

        double calculatedVolume = waterOverflow.calculate(row, glassNum, pouredVolumeInMl);

        System.out.println(String.format("Calculated volume for row %s, glass %s is %s ml.", row, glassNum, calculatedVolume));
    }

    private static void validateArguments(String[] args) {
        boolean invalid = false;

        try {
            if (args.length < 3) {
                invalid = true;
            } else {
                Integer.parseInt(args[0]);
                Integer.parseInt(args[1]);
                Double.parseDouble(args[2]);

                if (args.length == 4) {
                    Double.parseDouble(args[3]);
                }
            }

        } catch (NumberFormatException e) {
            invalid = true;
        }

        if (invalid) {
            System.out.println("Required application arguments: [row] [glass number] [poured liquid volume in ml]");
            System.out.println("Optional application argument (defaults to 250): [glass capacity in ml]");
            System.out.println("java -jar [application Jar file location] [row] [glass number] [poured liquid volume in ml] [glass capacity in ml]");
            System.out.println("Example 1: java -jar build/libs/water-overflow-1.0.jar 3 2 2000 250");
            System.out.println("Example 2: java -jar build/libs/water-overflow-1.0.jar 3 2 2000");
            System.out.println("Result: Calculated volume for row 3, glass 2 is 218.75 ml.");

            System.exit(0);
        }
    }

}
