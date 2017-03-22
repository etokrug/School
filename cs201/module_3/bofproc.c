/*
 * =====================================================================================
 *
 *       Filename:  bofproc.c
 *
 *    Description:  Example buffer overflow for testing
 *
 *        Version:  1.0
 *        Created:  11/06/2015 09:18:18 AM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdio.h>
#define TARGET 3

void osCmd(){
    asm("       mov     $0xcafedead, %eax       ");
}

void bofproc(){
    int buffer[TARGET - 1];
    int i;

    for (i = 0; i < TARGET; i++)
        buffer[i] = i;

    buffer[TARGET] = (int) osCmd;
}

int main (int argc, char **argv){
    bofproc();

    return 0;
}

