#使用java镜像
FROM anapsix/alpine-java:latest
#项目端口
EXPOSE 18080
#切换到容器内部的工作目录
WORKDIR /tmp
#添加要运行的jar
COPY target/springboot-web-docker-demo-0.0.1.jar /tmp/springboot-web-docker-demo-0.0.1.jar
#容器启动后运行的命令
ENTRYPOINT ["java","-jar","springboot-web-docker-demo-0.0.1.jar"]
