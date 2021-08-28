# spring-boot-demo-exlore

## How-to

### Option 1. Run server on host

- Build using Gradle

  ```shell
  $ ./gradlew build
  ```

  - Takes about 1.5 minutes (tested on M1 Macbook Pro)

- Run jar file

  ```
  $ java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
  ```

### Option 2. Run on Docker

- Build the container

  ```shell
  $ docker compose build
  ```

- Run the container

  ```shell
  $ docker compose up
  ```
