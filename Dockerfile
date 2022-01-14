FROM openjdk:11.0.13 AS BUILD_IMAGE
ENV APP_HOME=/root/dev/myapp/
RUN mkdir -p $APP_HOME/src/main/java
WORKDIR $APP_HOME
COPY build.gradle.kts gradlew gradlew.bat $APP_HOME
COPY gradle $APP_HOME/gradle
# download dependencies
RUN ./gradlew build -x test --continue
COPY . .
RUN ./gradlew build --no-daemon

FROM openjdk:11.0.13-jre
WORKDIR /root/
COPY --from=BUILD_IMAGE /root/dev/myapp/build/libs/geo-spring-data-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java","-jar","geo-spring-data-0.0.1-SNAPSHOT.jar"]