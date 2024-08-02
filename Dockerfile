FROM adoptopenjdk/openjdk11
VOLUME /tmp
ADD student-service/target/student-service-0.0.1.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENV TZ="America/La_Paz"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Deureka.client.serviceUrl.defaultZone=http://discovery:8761/eureka/ -jar /app.jar" ]