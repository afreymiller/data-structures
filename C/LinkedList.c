
#include "LinkedList.h"

int main(void)
{
    struct node* list = BuildOneTwoThree();

    Push(&list, 13);

    Push(&(list->next), 42);

    int l;

    l = GetNth(list, 5);

    printf("%d\n", l);


    return 0;
}
