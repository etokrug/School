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

int main (int argc, char **argv) {
    int array[] = {1, 2, 3, 4};
    int sum = 0;
    int i;

    for (i = 0; i < sizeof(array) / sizeof(int); i++)
        sum += array[i];

    printf("sum = %d\n", sum);
    return 0;
}
