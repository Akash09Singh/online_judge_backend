#!/bin/bash

cpp_file="Submit.cpp"
input_file="input.txt"
output_file="outputCode.txt"
executable="program"
log_file="execution_log.txt"

g++ "$cpp_file" -o "$executable" > "$log_file" 2>&1

if [ $? -ne 0 ]; then
    echo "Compilation failed!" > "$output_file"
    cat "$log_file" >> "$output_file"
    exit 1
fi

./"$executable" < "$input_file" > "$output_file" 2> "$log_file"

if [ $? -ne 0 ]; then
    echo "Execution failed!" > "$output_file"
    cat "$log_file" >> "$output_file"
    exit 1
fi
