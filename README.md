# Tech Stacks
Comparison between different tech stacks. Each with a unique set of programming language, web framework and database connector. Fulfilling the following:

* (static) types in the programming language
* small, but pluggable, web framework
* no ORM but still safe database access

## Pre-requisite
Install [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Gradle](https://gradle.org/)
```
brew cask install java
brew install gradle
```

## Usage
Note! Right now you need to manually build the Kotlin stack (will be part of Docker later).
```
cd stack_kotlin
gradle wrapper
./gradlew build
```

Make sure [Docker](https://www.docker.com/) and [docker-compose](https://docs.docker.com/compose/) is available, then run:
```
docker-compose build
docker-compose up
```

The different tech stacks will are now up and running. You can access them each via specific port numbers, i.e:

```
> curl localhost:9001
Hello from the Kotlin world!
> curl localhost:9002
Hello from the Python world!
```
