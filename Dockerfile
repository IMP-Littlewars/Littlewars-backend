FROM amazoncorretto:11.0.14

EXPOSE 40000

ARG JAR_FILE=build/libs/*.jar

ADD ${JAR_FILE} littlewars_be_image.jar

ENTRYPOINT ["java","-jar","/littlewars_be_image.jar"]
