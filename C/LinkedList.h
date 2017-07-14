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

int Count(struct node* head, int searchFor)
{
    int count = 0;

    while(head != NULL)
    {
        if(head->data == searchFor)
        {
            count++;
        }
    }

    return count;
}

int GetNth(struct node* head, int index)
{
    int val, dataFound, count;
    count = 0;
    dataFound = -1; //signifies we have not found data yet

    while(head != NULL)
    {
        if(count == index)
        {
            return head->data;
        }
        else
        {
            head = head->next;
            count++;
        }
    }

    assert(dataFound != -1);
    return 0;
}

void DeleteList(struct node** head_ref)
{
   /* deref head_ref to get the real head */
   struct node* current = *head_ref;
   struct node* next;
 
   while (current != NULL) 
   {
       next = current->next;
       free(current);
       current = next;
   }
   
   /* deref head_ref to affect the real head back
      in the caller. */
   *head_ref = NULL;
}