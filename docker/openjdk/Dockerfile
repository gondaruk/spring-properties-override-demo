FROM openjdk:11-jre-slim-buster

ENV APP_DIR /usr/share/app
RUN mkdir $APP_DIR \
    && useradd -ms /bin/bash app \
    && chown -R app:app $APP_DIR

WORKDIR $APP_DIR
USER app

ARG APP_NAME="spring-properties-override-demo"
ARG APP_VERSION="0.0.1-SNAPSHOT"

ENV APP_FILE=$APP_NAME-$APP_VERSION.jar

COPY /target/$APP_FILE ./app.jar
COPY docker/entrypoint.sh .

ENV SPRING_MAIN_BANNER_MODE=off
ENV LOGGING_LEVEL_ROOT=error

ENTRYPOINT ["./entrypoint.sh"]
