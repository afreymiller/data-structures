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
        printf("%d\n", head->data);
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

int Pop(struct node** head_ref)
{
    struct node* current = *head_ref;
    struct node* new_head;
    int val;

    new_head = current->next;
    val  = current->data;
    free(current);
    current = new_head;

    return val;
}

void InsertNth(struct node** headRef, int index, int data)
{
    if (index == 0)
    {
        Push(headRef, data);
    }
    else{
        struct node* current = *headRef;
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

void SortedInsert(struct node** headRef, struct node* newNode)
{
    if (*headRef == NULL || (*headRef)->data >= newNode->data)
    {
        newNode->next = *headRef;
        *headRef = newNode;
    }
    else
    {
        struct node* current = *headRef;
        while (current->next != NULL && current->next->data < newNode->data)
        {
            current = current->next;
        }
        newNode->next = current->next;
        current->next = newNode;
    }
}

void InsertSort(struct node** headRef)
{
    struct node* result = NULL;
    struct node* current = *headRef;
    struct node* next;

    while (current != NULL)
    {
        next = current->next;
        SortedInsert(&result, current);
        current = next;
    }

    *headRef = result;
}

void Append(struct node** aRef, struct node** bRef)
{
    struct node* current;

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

void FrontBackSplit(struct node* source, 
    struct node** frontRef, struct node** backRef)
    {
        int len = Length(source);
        int i;
        struct node* current = source; 

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

void RemoveDuplicates(struct node* head)
{
    struct node* current = head;

    if(current == NULL) return;

    while(current->next != NULL)
    {
        if (current->data == current->next->data)
        {
            struct node* nextNext = current->next->next;
            free(current->next);
            current->next = nextNext;
        }
        else 
        {
            current = current->next;
        }
    }
}

void MoveNode(struct node** destRef, struct node** sourceRef)
{
    struct node* newNode = *sourceRef;
    assert(newNode != NULL);

    *sourceRef = newNode->next;

    newNode->next = *destRef;
    *destRef = newNode;
}