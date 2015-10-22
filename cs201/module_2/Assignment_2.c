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

int main() {
    // Main set of declarations here
    int decimal;
    
    // Main input here
    printf("Enter Decimal Number: ");
    scanf("%d", &decimal);

    // TODO: Add in calls to your methods here

    // Standard output
    printf("Output Binary Number: ");

   // TODO: Add print statements here. 
    return 0;
}

int* convertDecToBinary(int converter) {
    // Initialize the "32 bit" int arrays we'll be using to handle the conversions
    int allNumbers[33];
    int tempNumbers[33];
    int numbersLen = sizeof(allNumbers)/sizeof(int);
int remainder;
    int negative = 0;
    
 // If the number is negative switch it to positive for handling.
    // Mark the negative bool as true.
    if (converter < 0) {
        negative = 1;
        converter *= -1;
    }
    
// Initizalize the values of the "32 bit" array
    int initializeInt = 0;
    for (initializeInt; initializeInt < numbersLen; initializeInt++) {
        if (negative) {
            allNumbers[initializeInt] = 1;
        }
        else {
            allNumbers[initializeInt] = 0;
        }
    }
// This sets the quotient equal to the decimal number.
    // This is done so that it can be later manipulated into the correct number.
    remainder = converter;

// Main body of the program here.
    // Loads the temporary array with the final values if positive.
    // Loads the temporary arry with the inverted values if negative.
    int temp = 1;
    int remainderHolder = 0;
    while(remainder > 0){
        if (negative) {
           if (remainder % 2 == 0) {
               remainderHolder = 1;
           }
           else {
               remainderHolder = 0;
           }
        }
        else {
            remainderHolder = remainder % 2;
        }
        tempNumbers[temp++] = remainderHolder;
        remainder /= 2;
        if (remainder == 0 && negative) {
            tempNumbers[temp] = 1;
        }
        else { tempNumbers[temp] = 0; }
    }

    // Transfer the information for our temp array to the main one for printing
    int stopper = 0;
    while (temp > stopper) {
        allNumbers[stopper] = tempNumbers[stopper];
        stopper++;
    }

    // Add one to the the final array if it is negative so that it can
    // be a complete Two's Complement.
    stopper = 0;
    int breakBit = 1;
    int carryBit = 0;
    if (negative) {
        while (stopper < numbersLen) {
            if (allNumbers[stopper] == 0) {
                if (breakBit || carryBit) {
                    allNumbers[stopper] = 1;
                    breakBit = 0;
                    carryBit = 0;
                }
                else {
                    breakBit = 0;
                    carryBit = 0;
                }
            }
            else {
                if (carryBit == 0) {
                    allNumbers[stopper] = 0;
                }
            }
            if (!breakBit) { break; }
            stopper++;
        }
    }
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
    

    // TODO: implement proper return;
    return;
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
            else {
                breakBit = 0;
            }
        }
        else {
            bitsToAddTo[stopper] = 0;
        }
        if (!breakBit) { break; }
        stopper--;
    }
}

char* convertDecToHex(int converter) {


    // TODO: implement proper return;
    return;
}

int printBinaryArray(int* binaryArray) {
    if (!binaryArray) { return -1; }
    
    int binaryLen = sizeof(binaryArray)/sizeof(int);

    // every four bits for clarity.
    int space = 0;
    int i = binaryLen - 1;
    for(i; i > 0; i--){
        if (space == 4) {
            printf("%s", " ");
            space = 0;
        }
        printf("%d", binaryArray[i]);
        space++;
    }

    return 0;
}

int printHexArray(char* hexArray) {
    if (!hexArray) { return -1; }
    printf("%s", hexArray);
}

