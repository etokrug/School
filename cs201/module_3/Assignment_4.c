/*
 * =====================================================================================
 *
 *       Filename:  Assignment_4.c
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  11/6/2015
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
int bigOrLittleEndian();
int* breakByteSections(int bigOrLittleEndian, int bytesToBreak, int* holdingArray);
int getBytesToBreak(int* arrayToAlter);
void printArrayInHex(int* holdingArray, int arraySize);
void printValueInHex(int hexInt);
int generateFinalInt(int* holdingArray, int arraySize);
void printMain(int bigEndian, int* holdingArray, int arraySize, int finalInt);

int main() {
    // Main set of declarations here
    int max = 50;
    int arraySize = 4;
    int halt = 0;
    int bytesToBreak = 0;
    int byteSections[arraySize + 1];
    int bigEndian = 0; // If this is 1 then it's big if not then small
    int intsToWork[max];
    int numberOfInts = 0;
    int finalInt = 0;

    // Main input here

    while (!halt) {
        bigEndian = bigOrLittleEndian();
        numberOfInts = getBytesToBreak(intsToWork);

        int i = 0;
        for (i; i < numberOfInts; i++) {
            if (intsToWork[i] == 0) {
                halt = 1;
            }
            else {
                breakByteSections(bigEndian, intsToWork[i], byteSections);
                finalInt = generateFinalInt(byteSections, arraySize);
                printMain(bigEndian, byteSections, arraySize, finalInt);
            }
        }
    }
    
    return 0;
}

int bigOrLittleEndian(){
    // Returns 1 for big endian 0 for little endian
    int userInp = 0;
    int clear = 0;
    printf("Output in big endian or little endian format? Type a number from below.\n");
    printf("1.) byte order: big-endian.\n");
    printf("2.) byte order: little-endian.\n");
    printf("Input number: ");
    scanf("%d", &userInp);
    while ((clear = getchar()) != EOF && clear != '\n');

    switch (userInp){
    case 1:
        return 1;
        break;
    case 2:
        return 0;
        break;
    default:
        printf("Input: %d is an invalid value.\n\n", userInp);
        return bigOrLittleEndian();
        break;
    }
}

int* breakByteSections(int bigOrLittleEndian, int bytesToBreak, int* holdingArray) {
    int oneByteMask = 255; // 1111 1111
    int oneByteHolder = 0;
    int bitMoves = 0;
    int i = 0;
    int j = 3;

    // if the user chose little-endian
    if (bigOrLittleEndian == 0) {
        for (i; i < 4; i++){
            bitMoves = j * 8;
            oneByteHolder = oneByteMask << bitMoves;
            holdingArray[i] = bytesToBreak & oneByteHolder; 
            j--;
        }
    }
    else {
        for (i= 3; i >= 0; i--) {
            bitMoves = j * 8;
            oneByteHolder = oneByteMask << bitMoves;
            holdingArray[i] = bytesToBreak & oneByteHolder;
            j--;
        }
    }

    return holdingArray;
}

int generateFinalInt(int* holdingArray, int arraySize){
    int returnInt = 0;
    int i = 0;
    for (i; i < arraySize; i++){
        returnInt = returnInt | holdingArray[i];
    }

    return returnInt;
}

void printArrayInHex(int* holdingArray, int arraySize){
    int i = 0;
    for (i; i < arraySize; i++) {
        printValueInHex(holdingArray[i]);
        if (!(i == arraySize - 1)) {
            printf(", ");
        }
    }
}

void printMain(int bigEndian, int* holdingArray, int arraySize, int finalInt) {
    printf("\n");
    if (bigEndian) {
        printf("***************Big-Endian format***************\n\n");
    }
    else {
        printf("***************Little-Endian format***************\n\n");
    }

    printf("Hex array broken: ");
    printArrayInHex(holdingArray, arraySize);
    printf("\nFinal Int: ");
    printValueInHex(finalInt);
    printf("\nb10 Format: %d\n\n", finalInt);

}

void printValueInHex(int hexInt) {
    printf("0x%X", hexInt);
}

int getBytesToBreak(int* arrayToAlter) {
    int max = 50;
    int halt = 0;
    int tempInt = 0;
    char temp[255];
    printf("Please enter a numeric value then press [enter] if you would like to add another.\n");
    printf("When you are done entering values just press enter again.\n");
    printf("If you are done and would like to exit enter 0 as the last value.\n");
    printf("Enter your numbers:\n");

    int counter = 0;
    while (!halt) {
        printf("%d> ", counter + 1);
        fgets(temp, max - 1, stdin);
        if (temp[0] == '\n'){
            halt = 1;
        }
        else {
            sscanf(temp, "%d", &tempInt);
            arrayToAlter[counter] = tempInt;
        }
        counter++;
    }

    return counter - 1;
}
