# spring-boot-demo-exlore

## Build using Gradle

- Takes about 1.5 minutes (tested on M1 Macbook Pro)

  ```shell
  $ ./gradlew build
  ```

## Option 1. Run server on host

- Run jar file

  ```
  $ java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
  ```

## Option 2. Using Docker container

- Build the container

  ```shell
  $ docker build --build-arg JAR_FILE=build/libs/\*.jar -t springio/gs-spring-boot-docker .
  ```

- Run the container

  ```shell
  $ docker run -p 8080:8080 -t springio/gs-spring-boot-docker
  ```
