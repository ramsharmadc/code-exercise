/*
 * SimpleThreading.cpp
 *
 *  Created on: Oct 8, 2020
 *      Author: ramsharma
 */

#include "SimpleThreading.h"

//#include <pthread.h>
#include <stdio.h>
#include <cstdlib>

volatile int counter = 0;
int loops;

void *
worker (void *arg)
{
  int i;
  for (i = 0; i < loops; i++)
    {
      counter++;
    }
  return nullptr;
}

SimpleThreading::SimpleThreading ()
{
  // TODO Auto-generated constructor stub

}

SimpleThreading::~SimpleThreading ()
{
  // TODO Auto-generated destructor stub
}

int
check_threads (int argc, char *argv[])
{
  if (argc != 2)
    {
      fprintf (stderr, "usage: threads <value>\n");
      exit (1);
    }
  loops = atoi (argv[1]);
//  pthread_t p1, p2;
  printf ("Initial value : %d\n", counter);

//  Pthread_create (&p1, NULL, worker, NULL);
//  Pthread_create (&p2, NULL, worker, NULL);
//  Pthread_join (p1, NULL);
//  Pthread_join (p2, NULL);
  printf ("Final value : %d\n", counter);
  return 0;
}
