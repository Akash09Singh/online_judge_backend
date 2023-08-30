# Use an Ubuntu base image
FROM ubuntu:latest

# Install Python
RUN apt-get update && \
    apt-get install -y python3 && \
    rm -rf /var/lib/apt/lists/*

# Copy your code and input files
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN chmod +x executePythonCode.sh

ENTRYPOINT ["./executePythonCode.sh"]
