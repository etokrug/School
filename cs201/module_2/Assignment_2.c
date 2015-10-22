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
int* invertBits(int* bitsToFlip, int arraySize);
int* addOneBitToBitArray(int* bitsToAddTo, int arraySize);
void printBinaryArray(int* binaryArray, int arraySize);
int* convertDecToBinary(int converter, int* allNumbers, int arraySize);
int getByteSet(int converter, int bytesToShift);
int mask(int start, int end);
int addExtractedBits(int numberToExtract, int mask, int maskBegin);

int main() {
    // Main set of declarations here
    int decimal;
    int arraySize = 32;
    int numberArray[arraySize - 1];
    int maskBegin = 3;
    int maskEnd = 4;
    int output = 0;

    // Main input here
    printf("Enter Decimal Number: ");
    scanf("%d", &decimal);
    printf("\n");

    convertDecToBinary(decimal, numberArray, arraySize);

    // Standard output
    printf("Output Binary Number: ");
    printBinaryArray(numberArray, arraySize);
    printf("\n");

    printf("Output Hex Number: %X\n", decimal);

    output = addExtractedBits(decimal, maskBegin, maskEnd);

    printf("Output of extracted bits added together: %d\n", output);
    
    return 0;
}

int addExtractedBits(int numberToExtract, int maskBegin, int maskEnd) {
    int i = 0;
    int bitLoop = 8;
    int returnInt = 0;
    int holderInt = 0;
    int maskInt = mask(maskBegin, maskEnd);
    for (i; i < 4; i++) {
        holderInt = getByteSet(numberToExtract, i);
        holderInt = holderInt & maskInt;
        holderInt = holderInt >> maskBegin;
        returnInt += holderInt;
    }
    return returnInt;
}

int* convertDecToBinary(int converter, int* allNumbers, int arraySize) {
    // Initialize the n-bit int arrays we'll be using to handle the conversions
    int numbersLen = arraySize - 1;
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
    int temp = numbersLen;
    while(remainder > 0){
        allNumbers[temp--] = remainder % 2;
        remainder /= 2;
    }

    if (negative) {
        invertBits(allNumbers, arraySize);
        addOneBitToBitArray(allNumbers, arraySize);
    }

    return allNumbers;
}


int mask(int start, int end) {
    int i = start;
    int maskHolder = 0;
    int returnInt = 0;
    for (i; i <=  end; i++) {
        maskHolder = 1 << i;
        returnInt = returnInt | maskHolder;
    }
    return returnInt;
}

int getByteSet(int converter, int bytesToShift) {
    int returnInt = converter >> bytesToShift * 8;
    return returnInt;
}

int* invertBits(int* bitsToFlip, int arraySize) {
    //int bitLen = arraySize - 1;

    int i = 0;
    for (i; i < arraySize; i++) {
        if (bitsToFlip[i] == 0) {
            bitsToFlip[i] = 1;
        }
        else {
            bitsToFlip[i] = 0;
        }
    }
    
    return bitsToFlip;
}

int* addOneBitToBitArray(int* bitsToAddTo, int arraySize) {
    int breakBit = 1;
    int stopper = arraySize - 1;
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

void printBinaryArray(int* binaryArray, int arraySize) {
    if (!binaryArray) { printf("\nThe binary array passed was empty!\n"); }
    
    // every four bits for clarity.
    int space = 0;
    int i = 0;
    for(i; i < arraySize; i++){
        if (space == 4) {
            printf(" ");
            space = 0;
        }
        printf("%d", binaryArray[i]);
        space++;
    }
}
