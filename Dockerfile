FROM openjdk:12
ADD target/dna-analyzer.jar dna-analyzer.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "dna-analyzer.jar"]