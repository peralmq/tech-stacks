FROM openjdk:8-jre-alpine

COPY ./build/libs/stack-kotlin.jar /stack-kotlin.jar

CMD ["java", \
     "-server", \
     "-Xms4g", \
     "-Xmx4g", \
     "-XX:+UseG1GC", \
     "-XX:MaxGCPauseMillis=100", \
     "-XX:+UseStringDeduplication", \
     "-jar", "stack-kotlin.jar"]

#FROM gradle:alpine

#COPY ./src /src
#COPY ./build.gradle /
#COPY ./gradle.properties /
#COPY ./settings.gradle /

#RUN gradle wrapper
#RUN ./gradlew build
