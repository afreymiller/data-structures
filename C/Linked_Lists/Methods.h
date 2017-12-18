#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include "models.h"

/* Initialize and return a linked list of three nodes */
node* build_one_two_three() {
    node* first = malloc(sizeof(*first));
    node* second = malloc(sizeof(*second));
    node* third = malloc(sizeof(*third));

    assert(first && second && third);

    *first = (node){ 1, second };
    *second = (node){ 2, third };
    *third = (node){ 3, NULL };

    return first;
}

/* Given a linked list, return its length */
int get_length(node* head) {
    int count = 0;

    while (head != NULL) {
        count++;
        head = head->next;
    }

    return count;
};

/* Given a linked list and value to search for, 
   return the frequency of that value */
int get_frequency(node* head, int val) {
    int count = 0;

    while (head != NULL) {
        if(head->data == val){
            count++;
        }
        head = head->next;
    }

    return count;
}

/* Given a linked list and index, return
the value at that index if applicable */
int get_nth(node* head, int index) {
    int val, nthFound, count;
    count = 0;
    nthFound = -1; //denotes we have not found data yet

    while(head != NULL) {
        if(count == index) {
            return head->data;
        }
        else {
            head = head->next;
            count++;
        }
    }

    assert(nthFound != -1);
    return 0;
}

/* Given a double-pointer to a linked list,
append a new head to the linked list of 
specified data */
void push(node** head, int new_data) {
    node * new_head = malloc(sizeof(*new_head));

    new_head->next = *head;
    new_head->data = new_data; 
    *head = new_head;
}

/* DIAGRAM
           
 head *: |1|*| -> |2|*| -> |3|x|, new_head *: |4|x|
 new_head *, head *: |4|x| -> |1|*| -> |2|*| -> |3|x|
 head = new_head

*/

void InsertNth(node** headRef, int index, int data){
    if (index == 0)
    {
        push(headRef, data);
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

        push(&(current->next), data);
    }
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
        int len = get_length(source);
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