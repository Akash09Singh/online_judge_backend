# Use an Ubuntu base image


# Install required packages (for Ubuntu)
FROM ubuntu:latest
RUN apt-get update && \
    apt-get install -y g++ && \
    rm -rf /var/lib/apt/lists/*
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN chmod +x executeCode.sh

ENTRYPOINT ["./executeCode.sh"]
VOLUME ["outputCode.txt"]