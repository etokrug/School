/*
 * =====================================================================================
 *
 *       Filename:  ifstmt.c
 *
 *    Description:  Lesson Code
 *
 *        Version:  1.0
 *        Created:  11/05/2015 04:09:44 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  William Brown 
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv){
    int n = argc > 1 ? atoi(argv[1]) : 0;
    char *str;

    if (n <= 0)
        str = "zero";
    else if (n == 1)
        str = "one";
    else if (n == 2)
        str = "two";
    else str = "> two";

    printf("x = %d, str = \"%s\"\n", n, str);
    return 0;
}
