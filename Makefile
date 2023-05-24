APP_NAME:=spring-properties-override-demo

ROOT = $(shell pwd)

docker-build:
	@docker build -f ./docker/openjdk/Dockerfile -t $(APP_NAME):openjdk .

docker-run:
	@docker run --rm -it \
		-v "$(ROOT)/docker/application.properties:/opt/usr/conf/application.properties" \
		-e "spring.config.location=/opt/usr/conf/application.properties" \
		-e "demo.example3=EnviromentVariableWithDotsInTheName" \
		$(APP_NAME):openjdk
