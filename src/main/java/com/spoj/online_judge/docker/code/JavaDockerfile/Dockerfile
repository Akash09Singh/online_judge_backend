# Use an Ubuntu base image
FROM ubuntu:latest

# Install Java
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    rm -rf /var/lib/apt/lists/*

# Copy your code and input files
COPY . /usr/src/myapp
COPY ../ /usr/src/myapp
WORKDIR /usr/src/myapp
RUN chmod +x executeJavaCode.sh

ENTRYPOINT ["./executeJavaCode.sh"]
