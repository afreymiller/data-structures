#include "minunit.h"

MU_TEST(get_nth_head) {
    int head;
	node* list = build_one_two_three();
	head = get_nth(list, 0);
	mu_check(head == 1);
}

MU_TEST(get_nth_second) {
    int second;
	node* list = build_one_two_three();
	second = get_nth(list, 1);
	mu_check(second == 2);
}

MU_TEST(get_nth_tail) {

}

MU_TEST(get_nth_out_of_bounds) {

}

MU_TEST_SUITE(get_nth_suite) {
	MU_RUN_TEST(get_nth_head);
	MU_RUN_TEST(get_nth_second);
}