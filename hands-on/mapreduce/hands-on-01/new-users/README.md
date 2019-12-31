# New Users Example

## Objectives of this labs
- Count number of new register users from stackoverflow

## Environment
- [Java](/installation/java.md)
- [Maven](/installation/maven.md)

## Run

- Please, remove folder `output` inside project root folder if existed

```
mvn install exec:java -Dexec.mainClass="vn.fpt.NewUsersCalc" -Dexec.args="./input ./output"
```

- Run plain java

```
mvn install exec:java -Dexec.mainClass="vn.fpt.NewUsersJava"
```