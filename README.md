
Ex1

The projects main function is the conversion of numbers from one base to another. Additionally, it also provides extra features such as the sum and multiplier of 2 numbers given by the user in a certain base etc. 

Example of console:
    console-Enter a string as number#1 (or "quit" to end the program)
    user-18b16
    console-num1 = 18b16 is valid , value 24
    console-Enter a string as number#2(or "quit" to end program)
    user-563b7
    console-num2 =563b7 is valid , value 290
    console-enter a base for output [2 , 16]
    user-9
    console-
        18b16 + 563b7 = 378b9
        18b16 * 563b7 = 10483b9
        Max Over [18b16,563b7,378b9,10483b9] = 10483b9
        Enter a string as number#1 (or "quit" to end the program)
    user-quit
    console-quiting...
    
The project is built with 3 main classes:

Main-the main class where the input and output is initialized
Ex1-the class where all the calculation and conversion function are initialized
Ex1Test-the class with the JUNIT testing in order to check if the function in Ex1 work accordingly

Functions:
1.number2Int - a function that converts a number with a given base to its decimal value.
2.Int2Number - a function which receives a   decimal number and a target base and converts the decimal number to the representation of the given base.
3.isNumber - Validate if a given string is indeed a valid number in its specified base.
4.BaseValue - Extract the base from a given number in its string representation.
5.CharValue - returns the value of letters in the string accordingly (A=10 ... G=16)
6.maxIndex - Determine the maximum value among a list of number strings.
7.equals - checks if 2 numbers are equal regardless to their representation.

Testing
The class Ex1Test provides JUNIT tests to ensure that the code is working accordingly.
