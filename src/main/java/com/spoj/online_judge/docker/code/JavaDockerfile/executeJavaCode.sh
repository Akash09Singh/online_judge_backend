#!/bin/bash

java_file="Submit.java"
input_file="input.txt"
output_file="outputCode.txt"
log_file="execution_log.txt"
executable="program"

javac "$java_file" > "$log_file" 2>&1

if [ $? -ne 0 ]; then
    echo "Compilation failed!" > "$output_file"
    cat "$log_file" >> "$output_file"
    exit 1
fi

java "$executable" < "$input_file" > "$output_file" 2> "$log_file"

if [ $? -ne 0 ]; then
    echo "Execution failed!" > "$output_file"
    cat "$log_file" >> "$output_file"
    exit 1
fi
