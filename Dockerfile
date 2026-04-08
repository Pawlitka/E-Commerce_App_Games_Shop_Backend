# ETAP 1: Budowanie (JDK 23)
FROM bellsoft/liberica-openjdk-alpine:23 AS build
WORKDIR /app

# Kopiujemy wrapper Mavena (opcjonalnie, jeśli go używasz - to najlepsza praktyka)
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# Pobieramy zależności - to się wycache'uje
RUN ./mvnw dependency:go-offline -B

# Kopiujemy źródła i budujemy
COPY src ./src
RUN ./mvnw clean package -DskipTests

# ETAP 2: Uruchamianie (JRE 23 - odchudzone)
FROM bellsoft/liberica-openjre-alpine:23
WORKDIR /app

# Kopiujemy JAR-a z etapu 'build'
COPY --from=build /app/target/*.jar app.jar

# Bezpieczeństwo: uruchamiamy jako użytkownik bez uprawnień roota
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

EXPOSE 8080

# Opcjonalnie: optymalizacja pod wirtualne wątki (Java 21+)
ENTRYPOINT ["java", "-jar", "app.jar"]