#include "minunit.h"

MU_TEST(test_length_init) {
	int len;
	node* list = build_one_two_three();
	len = get_length(list);
	mu_check(len == 3);
}

MU_TEST(test_length_add_1) {
	int len;
	node* list = build_one_two_three();
	push(&list, 4);
	len = get_length(list);
	mu_check(len == 4);
}

MU_TEST(test_length_add_2) {
	int len;
	node* list = build_one_two_three();
	push(&list, 5);
	push(&list, 6);
	len = get_length(list);
	mu_check(len == 5);
}

MU_TEST_SUITE(length) {
	MU_RUN_TEST(test_length_init);
	MU_RUN_TEST(test_length_add_1);
	MU_RUN_TEST(test_length_add_2);
}