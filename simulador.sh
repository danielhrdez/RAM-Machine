#!/bin/bash
javac -d bin $(find ./src/ram/* | grep .java)
java -cp ./bin ram.Ram ./src/test/test$1.ram ./input_tape.in ./output_tape.out