#include "minunit.h"

MU_TEST(push_1) {
    int len;
	node* list = build_one_two_three();
	push(&list, 5);
    push(&list, 8);
    len = get_length(list);
	mu_check(len == 5);
}

MU_TEST(push_2) {
    int head;
    node* list = build_one_two_three();
    push(&list, 6);
    head = get_nth(list, 0);
    mu_check(head == 6);
}

MU_TEST_SUITE(push_suite) {
	MU_RUN_TEST(push_1);
	MU_RUN_TEST(push_2);
}