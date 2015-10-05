/*
 * =====================================================================================
 *
 *       Filename:  boolbitops.c
 *
 *    Description:  // demonstrates the C boolean bitwise operations
 *
 *        Version:  1.0
 *        Created:  10/04/2015 11:10:39 PM
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
        short       x = 0x010F;
        short       y = 0x0F00;
        short       v;

        printf("C boolean bitwise operations\n");
        printf("          x = 0x%04hX\n", x);
        printf("          y = 0x%04hX\n", y);
                           
        // not
        v = ~x;
        printf("not:     ~x = 0x%04hX\n", v);
        
        // or
        v = x | y;
        printf("or:   x | y = 0x%04hX\n", v);
        
        // and
        v = x & y;
        printf("and:  x & y = 0x%04hX\n", v);
        
        // exclusive or (xor)
        v = x ^ y;
        printf("xor:  x ^ y = 0x%04hX\n", v);
        return 0;
}
