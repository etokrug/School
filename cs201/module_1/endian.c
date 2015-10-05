/*
 * =====================================================================================
 *
 *       Filename:  endian.c
 *
 *    Description:  endian test file
 *
 *        Version:  1.0
 *        Created:  10/04/2015 08:51:23 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (), 
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdio.h>
#include <stdlib.h>

void printBytes (char *p, int nBytes)
{
        int     i;
            
            printf("bytes: ");
                for (i = 0; i < nBytes; i++, p++)
                            printf("%02X", *p);
                    printf("\n");
}

int main (int arg, char **argv)
{
        int     n4 = 0x0A0B0C0D;
            short   n2 = 0x0A0B;

                printf("endian demo\n\n");
                    
                    printf("int:   %08X\n", n4);
                        printBytes((char *) &n4, sizeof(n4));
                            printf("\n");
                                
                                printf("short: %04X\n", n2);
                                    printBytes((char *) &n2, sizeof(n2));
                                        printf("\n");
                                            
                                            return 0;
}
