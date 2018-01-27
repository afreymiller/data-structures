
#include "methods.h"

int main(void)
{
    node* list = build_one_two_three();

    push(&list, 13);
    push(&list, 2);

   // Push(&(list->next), 42);

    insert_nth(&list, 3, 5);
    int l = get_nth(list, 3);
    printf("%d\n", l);

    return 0;
}
