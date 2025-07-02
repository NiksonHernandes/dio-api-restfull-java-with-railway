FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY . ./

RUN chmod +x ./mvnw && ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/*.jar"]
