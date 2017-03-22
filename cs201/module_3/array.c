/*
 * =====================================================================================
 *
 *       Filename:  array.c
 *
 *    Description:  Assignment Array Lesson
 *
 *        Version:  1.0
 *        Created:  11/05/2015 03:48:38 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  William Brown
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdio.h>
void usingIndex();
void usingPointer();


int main (int argc, char **argv) {
    usingIndex();
    usingPointer();
    return 0;
}

void usingIndex() {
    int array[] = {1, 2, 3, 4};
    int sum = 0;
    int i;

    for (i = 0; i < sizeof(array) / sizeof(int); i++)
        sum += array[i];
    
    printf("Sum using an index:\n");
    printf("sum = %d\n", sum);
}

void usingPointer(){
    int array[] = {1, 2, 3, 4};
    int sum = 0;
    int *p;

    for (p = array; p < &array[sizeof(array)/sizeof(int)]; p++)
        sum += *p;

    printf("Sum using a pointer:\n");
    printf("sum = %d\n", sum);
}













