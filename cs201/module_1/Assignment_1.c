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
    
    // This is the array that will end up (I hope) holding the full binary number
    // I set it to 31 to represent a 32 bit system - I think
    int allNumbers[32];
    

    // Main input here - still getting used to C vs C++/C#
    printf("Enter Decimal Number: ");
    scanf("%d", &decimal);

    if (decimal < 0) {
        negative = true;
        decimal *= -1;
    }
    
    // This sets the quotient equal to the decimal number.
    // This is done so that it can be later manipulated into the correct number.
    remainder = decimal;

    int i = 1;
    int remainderHolder = 0;
    while(remainder > 0){
        if (i == 1) {
            if (!negative) {
            
            }
        }

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
    
        allNumbers[i++] = remainderHolder;
        remainder /= 2;
    }

    // Standard output
    printf("Output Binary Number: ");

    int j = i - 1;
    for(j; j > 0; j--){
        printf("%d", allNumbers[j]);
    }

    printf("\n");
    
    return 0;
}







