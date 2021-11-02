# Java Flink Application
Java flink applications need to be pacakged as executable jar files in order to submit them to the Flink session cluster. Maven can be used to package Java Flink applications.

## Maven
Download and install maven from https://maven.apache.org/

To package an executable jar file:
1. Specify the main class in pom.xml segment below
```
<transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
  <mainClass>example.WordCountJob</mainClass>
</transformer>
```
2. Run the maven target to package the file
```
mvn clean compile package
```
The package executable jar file is available in the ./target folder

## Submit a Flink job
To submit the flink job run the command from the flink base folder

```
./bin/flink run <path to executable jar file>
```
e.g,
```
./bin/flink run /Users/ESumitra/workspaces/flink/java/flinkapp/target/flink-java-app-0.1.jar
```

Copyright 2021, Edward Sumitra
