FROM artifactory.apps.bancolombia.com/devops/openjdk11-openj9:x86_64-alpine-jdk-11.0.3_7_openj9-0.14.3-slim
VOLUME /tmp
ENV SPRING_PROFILES_ACTIVE=#{envcontainer}#
ADD application-app-service.jar /
ENTRYPOINT java -jar /application-app-service.jar -g 'daemon off;'
EXPOSE 8080