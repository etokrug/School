/*
 * =====================================================================================
 *
 *       Filename:  Assignment_2.c
 *
 *    Description:  This program converts decimals to binary and hex.
 *                  It takes input from a user (expecting a proper input
 *                  with no error handling).
 *                  It extracts bits from HEX values and shifts them.
 *
 *        Version:  1.0
 *        Created:  10/21/2015
 *       Revision:  NONE
 *       Compiler:  gcc
 *
 *         Author:  William Brown
 *          Class:  CS 201
 *      Professor:  Ashis Chatterjee
 *   Organization:  PCC
 *
 * =====================================================================================
 */
#include <stdio.h>
int* invertBits(int* bitsToFlip);
int* addOneBitToBitArray(int* bitsToAddTo);
void printBinaryArray(int* binaryArray);
void printHexArray(char* hexArray);
int* convertDecToBinary(int converter, int* allNumbers);

int main() {
    // Main set of declarations here
    int decimal;
    int numberArray[33];

    // Main input here
    printf("Enter Decimal Number: ");
    scanf("%d", &decimal);

    convertDecToBinary(decimal, numberArray);

    // Standard output
    printf("Output Binary Number: ");
    printBinaryArray(numberArray);
    printf("/n");

    return 0;
}

int* convertDecToBinary(int converter, int* allNumbers) {
    // Initialize the n-bit int arrays we'll be using to handle the conversions
    int numbersLen = sizeof(allNumbers)/sizeof(int);
    int remainder;
    int negative = 0;
    
    // If the number is negative switch it to positive for handling.
    // Mark the negative bool as true.
    if (converter < 0) {
        negative = 1;
        converter *= -1;
    }
    
    // Initizalize the values of the n-bit array
    int initializeInt = 0;
    for (initializeInt; initializeInt < numbersLen; initializeInt++) {
        allNumbers[initializeInt] = 0;
    }
    // This sets the quotient equal to the decimal number.
    // This is done so that it can be later manipulated into the correct number.
    remainder = converter;

    // Main body of the program here.
    // Loads the temporary array with the final values if positive.
    // Loads the temporary arry with the inverted values if negative.
    int temp = numbersLen - 1;
    while(remainder > 0){
        allNumbers[temp--] = remainder % 2;
        remainder /= 2;
        allNumbers[temp] = 1;
    }

    if (negative) {
        invertBits(allNumbers);
        addOneBitToBitArray(allNumbers);
    }

    return allNumbers;
}

int* invertBits(int* bitsToFlip) {
    int bitLen = sizeof(bitsToFlip)/sizeof(int) - 1;

    int i = 0;
    for (i; i < bitLen; i++) {
        if (bitsToFlip[i] == 0) {
            bitsToFlip[i] = 1;
        }
        else {
            bitsToFlip[i] = 0;
        }
    }
    
    return bitsToFlip;
}

int* addOneBitToBitArray(int* bitsToAddTo) {
    int breakBit = 1;
    int stopper = sizeof(bitsToAddTo)/sizeof(int) - 1;
    while (stopper >= 0) {
        if (bitsToAddTo[stopper] == 0) {
            if (breakBit) {
                bitsToAddTo[stopper] = 1;
                breakBit = 0;
            }
        }
        else {
            bitsToAddTo[stopper] = 0;
        }
        if (!breakBit) { break; }
        stopper--;
    }
    return bitsToAddTo;
}

/* 
char* convertDecToHex(int converter) {


    // TODO: implement proper return;
    return;
}
*/

void printBinaryArray(int* binaryArray) {
    if (!binaryArray) { printf("/nThe binary array passed was empty!/n"); }
    
    int binaryLen = sizeof(binaryArray)/sizeof(int);

    // every four bits for clarity.
    int space = 0;
    int i = binaryLen - 1;
    for(i; i > 0; i--){
        if (space == 4) {
            printf(" ");
            space = 0;
        }
        printf("%d", binaryArray[i]);
        space++;
    }
}

void printHexArray(char* hexArray) {
    if (!hexArray) { printf("/nThe hex array passed was empty!/n"); }
    printf("%s", hexArray);
}

