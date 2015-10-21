/*
 * =====================================================================================
 *
 *       Filename:  TestScript.c
 *
 *    Description:  Test scripts in C
 *
 *        Version:  1.0
 *        Created:  10/16/2015 02:48:15 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  William Brown 
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdio.h>

int test1() {
    int x = 38;
    int y = 45;
    int z;

    z = x ^ y;
    z ^= x;

    return z;

}

int main() {
    int xyz = test1();

    printf("%d\n\n", xyz);

    return 0;
}
