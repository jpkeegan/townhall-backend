FROM maven
COPY . /home
WORKDIR /home
RUN mvn package
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/home/target/townhall-backend-0.0.1-SNAPSHOT.jar"]
