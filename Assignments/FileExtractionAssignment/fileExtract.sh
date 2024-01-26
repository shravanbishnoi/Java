#!/bin/bash

# Java class name
javaClass = "fileExtraction"

# Java directory path
directoryPath = "C:\\Users\\Shravan Bishnoi\\OneDrive\\Desktop\\JAVA\\Projects\\FileExtractionAssignment\\demofiles"

# Compile Java program
javac $javaClass.java

# Runs the specified java program
java $javaClass "$directoryPath"