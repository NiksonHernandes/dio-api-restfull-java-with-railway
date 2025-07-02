#FROM openjdk:21
#
#ADD ./docker-spring-boot.jar docker-spring-boot.jar
#
#ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]

# Usa imagem oficial Eclipse Temurin JDK 21 com Alpine
FROM eclipse-temurin:21-jdk-alpine

# Cria e move para o diretório da aplicação
WORKDIR /app

# Copia o projeto inteiro para dentro do container
COPY . ./

# Executa o build da aplicação com o Maven Wrapper
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Expõe a porta dinâmica usada pelo Railway
EXPOSE 8080

# Comando de execução que busca o .jar na pasta target
CMD ["sh", "-c", "java -jar target/*.jar"]
