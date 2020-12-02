FROM java:8
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar", "-Xmx600M","/app.jar"]