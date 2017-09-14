# Kotlin tech stack
Stack based on
* [Kotlin 1.1.4](https://docs.python.org/3/whatsnew/3.6.html) - Statically typed programming language for modern multiplatform applications, created by [JetBrains](https://www.jetbrains.com/) and one of the offical languages for Android
* [Ktor](http://ktor.io/) - a micro web framework
* [Gradle](https://gradle.org/) - a package, dependency management, and build tool

## Local development
```
./gradlew wrapper
./gradlew clean run
```

## Deployment
In order to get new source code in to the docker container the following is a needed prerequisite
```
./gradlew clean build
```


