#include "minunit.h"

MU_TEST(insert_nth_1) {
    int n;
	node* list = build_one_two_three();
	insert_nth(&list, 2, 6);
    n = get_nth(list, 2);
	mu_check(n == 6);
}

MU_TEST_SUITE(insert_nth_suite) {
	MU_RUN_TEST(insert_nth_1);
}