
#include "LinkedList.h"

int main(void)
{
    struct node* list = BuildOneTwoThree();

    Push(&list, 13);

   // Push(&(list->next), 42);

    int l = Length(list);

    printf("%d\n", l);

    return 0;
}
