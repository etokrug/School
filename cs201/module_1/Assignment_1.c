/*
 * =====================================================================================
 *
 *       Filename:  Assignment_1.c
 *
 *    Description:  This program converts decimals to binary.
 *                      It takes input from a user (expecting a proper input
 *                      with no error handling).
 *
 *        Version:  1.0
 *        Created:  10/04/2015 09:11:15 AM
 *       Revision:  none
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
    int remainder;
    static int true = 1;
    static int false = 0;
    int negative = false;
    
    // Initialize the "32 bit" int arrays we'll be using to handle the conversions
    int allNumbers[33];
    int tempNumbers[33];
    int numbersLen = sizeof(allNumbers)/sizeof(int);
    int tempLen = 0;

    // Main input here
    printf("Enter Decimal Number: ");
    scanf("%d", &decimal);

    // If the number is negative switch it to positive for handling.
    // Mark the negative bool as true.
    if (decimal < 0) {
        negative = true;
        decimal *= -1;
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
    remainder = decimal;

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

    // If sign is negative add one to
    tempLen = sizeof(tempNumbers)/sizeof(int);
    
    int stopper = 0;
    while (temp > stopper) {
        allNumbers[stopper] = tempNumbers[stopper];
        stopper++;
    }

    // Standard output
    printf("Output Binary Number: ");

    int space = 0;
    int all = numbersLen - 1;
    for(all; all > 0; all--){
        if (space == 4) {
            printf("%s", " ");
            space = 0;
        }
        printf("%d", allNumbers[all]);
        space++;
    }

    printf("\n");
    
    return 0;
}







