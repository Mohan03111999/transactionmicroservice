FROM openjdk:11

# Copy the jar to the production image from the builder stage.
COPY target/transactionms-*.jar /transactionms.jar

# expose container port for outer world
EXPOSE 8890

# Run the web service on container startup.
CMD java  -jar /transactionms.jar