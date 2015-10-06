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

    // This is the array that will end up (I hope) holding the full binary number
    // I set it to 31 to represent a 32 bit system - I think
    int allNumbers[31];

    // Main input here - still getting used to C vs C++/C#
    printf("Enter Decimal Number: ");
    scanf("%d", &decimal);

    // This sets the quotient equal to the decimal number.
    // This is done so that it can be later manipulated into the correct number.
    remainder = decimal;

    // This loop, although you stated pretty clearly what it should do
    // gave me a lot of problems and I had to search for some additional
    // online help. It's not that loops give me problems, rather this math
    // is not something I'm used to on any level and I'm kind of two weeks
    // behind because of my trip to Germany that we spoke about.
    int i = 1;
    while(remainder > 0){
        allNumbers[i++] = remainder % 2;
        remainder = remainder / 2;
    }

    // Standard output
    printf("Output Binary Number: ");

    // This was another loop that I had to get help with online
    // I'm used to working with blocks or strings that print easily.
    // Looking at this now it's clear to see that it's easy but it
    // took me a while to arrive at this.
    int j = i - 1;
    for(j; j > 0; j--){
        printf("%d", allNumbers[j]);
    }

    // Classically, I couldn't figure out why the output kept wrapping back onto
    // itself. Solution, add a newline.
    printf("\n");
    
    return 0;
}
