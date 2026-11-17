# Football League Simulation

## Requirements

- JDK 17 or newer (`java -version`)
- Apache Maven 3.9 or newer (`mvn -version`)

On Windows, install Maven with WinGet:

```powershell
winget install --id Apache.Maven --exact
```

Open a new terminal after installation so the Maven `bin` directory is on
`PATH`. Set `JAVA_HOME` to your JDK installation if it is not already set.

## Build and test

Run these commands from the repository root:

```powershell
mvn clean test
mvn package
```

Run the fixture-generation demo with:

```powershell
mvn compile exec:java
```

The application entry point is `main.java`; supporting Java sources are in
`simulation_object`. Maven compiles them for Java 17. Tests belong in
`src/test/java`. Maven writes compiled classes and reports to `target`; test
reports are in `target/surefire-reports`.