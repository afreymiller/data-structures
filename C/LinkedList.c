
#include "LinkedList.h"

int main(void)
{
    struct node* list = build_123();

    int l;

    l = Length(list);

    printf("%d\n", l);

    
    return 0;
}
