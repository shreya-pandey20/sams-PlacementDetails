FROM openjdk:11
WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/target/PlacementDetails-1.0.0.jar .
CMD java -jar PlacementDetails-1.0.0.jar
