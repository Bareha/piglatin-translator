# Overview
This is an English to Pig Latin translator

# Functions
- Accepts user input string
- Converts string to an array of words
- Iterates through the array and processes each word:
    - Case 1: Word begins with a vowel followed by a consonant
    - Case 2: Word begins with a vowel followed by another vowel
    - Case 3: Word begins with a consonant
- Modifies each word according to the respective case
- Throws a custom exception if the text is not purely alphabetic
- Ensures words that start with capital letters maintain capitalization in the Pig Latin translation

Note: input has to strictly alphabetic for the program to not throw an exception  
valid input - Hello World  
invalid input - Hello, World!
