/*
 * =====================================================================================
 *
 *       Filename:  rtshift.c
 *
 *    Description:      // demonstrates the difference between signed and unsigned
 *                      // numbers when they are right-shifted
 *
 *        Version:  1.0
 *        Created:  10/04/2015 11:19:29 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  William Brown 
 *   Organization:  PCC
 *
 * =====================================================================================
 */
#include <stdio.h>

int main (int argc, char **argv)
{
    signed int      s = 0x81234567;
    unsigned int    u = 0x81234567;
                
    printf("s = 0x%08X, u = 0x%08X\n", s, u);
    s >>= 4;
    u >>= 4;
    printf("(right shift both by 4)\n");
    printf("s = 0x%08X, u = 0x%08X\n", s, u);

    return 0;
}
