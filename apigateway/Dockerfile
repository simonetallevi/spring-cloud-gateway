FROM openjdk:11-stretch AS builder
WORKDIR /home/gradle/app
COPY . /home/gradle/app
RUN ./gradlew build

FROM openjdk:11-jdk-slim
WORKDIR /home/gradle/app
COPY --from=builder ./home/gradle/app/build/libs/apigateway-1.0.jar app.jar

EXPOSE 8080
CMD echo "Running app..." && exec java -Djava.security.egd=file:/dev/./urandom -jar app.jar

