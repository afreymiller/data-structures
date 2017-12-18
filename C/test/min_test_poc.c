#include "minunit.h"
#include "../Linked_Lists/Methods.h"

MU_TEST(test_count_init) {
	node* list = build_one_two_three();
	int count = get_length(list);
	mu_check(count == 3);
}

MU_TEST(test_count_add_1) {
	node* list = build_one_two_three();
	push(&list, 4);
	int count = get_length(list);
	mu_check(count == 4);
}

MU_TEST(test_count_add_2) {
	node* list = build_one_two_three();
	push(&list, 5);
	push(&list, 6);
	int count = get_length(list);
	mu_check(count == 5);
}

MU_TEST_SUITE(test_suite) {
	MU_RUN_TEST(test_count_init);
	MU_RUN_TEST(test_count_add_1);
	MU_RUN_TEST(test_count_add_2);
}

/* Arguments are optional */
int main(int argc, char *argv[]) {
	MU_RUN_SUITE(test_suite);
	MU_REPORT();
	return 0;
}