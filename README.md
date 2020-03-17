# Water Overflow Calculator

### Water Overflow Problem
There is a stack of water glasses in the form of triangle. Each glass has a 250ml capacity. 
When liquid is poured into the top most glass, any overflow is evenly distributed between the 
glasses in the next row. That is, half of the overflow pours into the left glass while the 
remainder of the overflow pours into the right glass.

Calculate how much liquid is in the j’th glass of the i’th row when K litres are poured 
into the top most glass.

### Requirement
* At least [Java 8 (JDK)](https://openjdk.java.net/install/index.html)

### Build the JAR
`./gradlew jar`

### Run the tests
`./gradlew test`

### How to use the program
Build the JAR first.

Required application arguments: [row] [glass number] [poured liquid volume in ml]
Optional application argument (defaults to 250): [glass capacity in ml]

`java -jar [application Jar file location] [row] [glass number] [poured liquid volume in ml] [glass capacity in ml]`

Example 1: `java -jar build/libs/water-overflow-1.0.jar 3 2 2000 250`

Example 2: `java -jar build/libs/water-overflow-1.0.jar 3 2 2000`

Result: `Calculated volume for row 3, glass 2 is 218.75 ml.`
