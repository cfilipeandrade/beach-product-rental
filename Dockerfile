# Use a imagem base do OpenJDK
FROM openjdk:11-jre-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR da sua aplicação para o contêiner
COPY target/beach-product-rental.jar /app/beach-product-rental.jar

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "beach-product-rental.jar"]
