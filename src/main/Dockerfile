# Use the official Ubuntu image as the base image
FROM ubuntu:latest

# Set environment variables to avoid interactive prompts during installation
ENV DEBIAN_FRONTEND=noninteractive

# Update the package list and install MySQL Server and MySQL Client
RUN apt-get update && \
    apt-get install -y mysql-server mysql-client && \
    rm -rf /var/lib/apt/lists/* && \
    apt-get clean

# Expose the default MySQL port
EXPOSE 3306

# Copy the SQL script
COPY create_database.sh /create_database.sh
COPY create_database.sql /create_database.sql

# Run the custom script to create the database
CMD ["/create_database.sh"]
