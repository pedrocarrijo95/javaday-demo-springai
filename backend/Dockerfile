# Etapa 1: Construir o aplicativo
FROM maven AS build
LABEL authors="pedro_carrijo"

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos de dependências do projeto
COPY pom.xml .

# Baixar dependências do Maven (cache)
RUN mvn dependency:go-offline

# Copia o código-fonte
COPY src ./src

# Compilar o projeto e gerar o JAR
RUN mvn clean package -DskipTests 

# Etapa 2: Criar a imagem final
FROM ghcr.io/graalvm/graalvm-ce:latest

# Define o diretório de trabalho para a aplicação
WORKDIR /app

#Define path OCI Config File
ENV OCI_CONFIG_FILE=./.oci/config

# Copia o ConfigFile gerado no build_spec.yaml 
COPY --from=build /app/src/.oci /app/.oci/

# Copia o JAR gerado na etapa de build 
COPY --from=build /app/target/spring-cloud-oci-starter-gen-ai-1.2.0.jar /app/app.jar

# Exponha a porta que o aplicativo usará
EXPOSE 8080

# Define o comando padrão para rodar o aplicativo
CMD ["java", "-jar", "app.jar"]
