#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include "Models.h"

int get_length(node* head) {
    int count = 0;

    while (head != NULL) {
        count++;
        head = head->next;
    }

    return count;
};

node * BuildOneTwoThree()
{
    node * first = malloc(sizeof(*first));
    node * second = malloc(sizeof(*second));
    node * third = malloc(sizeof(*third));

    assert(first && second && third);

    *first = (node){ 1, second };
    *second = (node){ 2, third };
    *third = (node){ 3, NULL };

    return first;
}

void Push(node** headRef, int newData)
{
    node * newHead = malloc(sizeof(*newHead));

    newHead->next = *headRef;
    newHead->data = newData; 

    *headRef = newHead;
}

int Count(node* head, int searchFor)
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

int GetNth(node* head, int index)
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

void DeleteList(node** head_ref)
{
   /* deref head_ref to get the real head */
   node* current = *head_ref;
   node* next;
 
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

int Pop(node** head_ref)
{
    node* current = *head_ref;
    node* new_head;
    int val;

    new_head = current->next;
    val  = current->data;
    free(current);
    current = new_head;

    return val;
}

void InsertNth(node** headRef, int index, int data)
{
    if (index == 0)
    {
        Push(headRef, data);
    }
    else{
        node* current = *headRef;
        int i;

        for(i=0; i<index-1; i++)
        {
            assert(current != NULL);
            current = current->next;
        }

        assert(current != NULL);

        Push(&(current->next), data);
    }
}

void SortedInsert(node** headRef, node* newNode)
{
    if (*headRef == NULL || (*headRef)->data >= newNode->data)
    {
        newNode->next = *headRef;
        *headRef = newNode;
    }
    else
    {
        node* current = *headRef;
        while (current->next != NULL && current->next->data < newNode->data)
        {
            current = current->next;
        }
        newNode->next = current->next;
        current->next = newNode;
    }
}

void InsertSort(node** headRef)
{
    node* result = NULL;
    node* current = *headRef;
    node* next;

    while (current != NULL)
    {
        next = current->next;
        SortedInsert(&result, current);
        current = next;
    }

    *headRef = result;
}

void Append(node** aRef, node** bRef)
{
    node* current;

    if (*aRef == NULL){
        *aRef = *bRef;
    }
    else
    {
        current = *aRef;
        while (current->next != NULL)
        {
            current = current->next;
        }
        current->next = *bRef;
    }
}

void FrontBackSplit(node* source, 
    node** frontRef, node** backRef)
    {
        int len = Length(source);
        int i;
        node* current = source; 

        if (len < 2)
        {
            *frontRef = source;
            *backRef = NULL;
        }   
        else 
        {
            int hopCount = (len-1)/2;
            for (i = 0; i < hopCount; i++)
            {
                current = current->next;
            }

            *frontRef = source;
            *backRef = current->next;
            current->next = NULL;
        }
    }

void RemoveDuplicates(node* head)
{
    node* current = head;

    if(current == NULL) return;

    while(current->next != NULL)
    {
        if (current->data == current->next->data)
        {
            node* nextNext = current->next->next;
            free(current->next);
            current->next = nextNext;
        }
        else 
        {
            current = current->next;
        }
    }
}

void MoveNode(node** destRef, node** sourceRef)
{
    node* newNode = *sourceRef;
    assert(newNode != NULL);

    *sourceRef = newNode->next;

    newNode->next = *destRef;
    *destRef = newNode;
}