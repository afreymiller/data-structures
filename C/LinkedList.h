#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

struct node 
{
    int data;
    struct node* next;
};

int Length(struct node* head)
{
    int count = 0;

    while (head != NULL)
    {
        count++;
        head = head->next;
    }

    return count;
};

struct node * BuildOneTwoThree()
{
    struct node * first = malloc(sizeof(*first));
    struct node * second = malloc(sizeof(*second));
    struct node * third = malloc(sizeof(*third));

    assert(first && second && third);

    *first = (struct node){ 1, second };
    *second = (struct node){ 2, third };
    *third = (struct node){ 3, NULL };

    return first;
}

void Push(struct node** headRef, int newData)
{
    struct node * newHead = malloc(sizeof(*newHead));

    newHead->next = *headRef;
    newHead->data = newData; 

    *headRef = newHead;
}