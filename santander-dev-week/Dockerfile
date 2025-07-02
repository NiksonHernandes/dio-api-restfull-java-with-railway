FROM eclipse-temurin:21-jdk-alpine

# Diretório da aplicação
WORKDIR /app

# Copia todo o projeto
COPY . ./

# Dá permissão ao Maven Wrapper
RUN chmod +x ./mvnw

# Executa o build da aplicação
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Expõe a porta (usada pelo Railway)
EXPOSE 8080

# Executa a aplicação
CMD ["sh", "-c", "java -jar target/*.jar"]
