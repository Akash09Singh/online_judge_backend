#!/bin/bash

python_file="Submit.py"
input_file="input.txt"
output_file="outputCode.txt"
log_file="execution_log.txt"

python "$python_file" < "$input_file" > "$output_file" 2> "$log_file"

if [ $? -ne 0 ]; then
    echo "Execution failed!" > "$output_file"
    cat "$log_file" >> "$output_file"
    exit 1
fi