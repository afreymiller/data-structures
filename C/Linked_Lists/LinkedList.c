
#include "Methods.h"

int main(void)
{
    node* list = BuildOneTwoThree();

    Push(&list, 13);

   // Push(&(list->next), 42);

    int l = get_length(list);

    printf("%d\n", l);

    return 0;
}
