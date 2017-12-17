#include "minunit.h"
#include "../Linked_Lists/Methods.h"

MU_TEST(test_check) {
	mu_check(7 == 7);
}

MU_TEST(test_count) {
	node* list = build_one_two_three();
	int count = get_length(list);
	mu_check(count == 3);
}

MU_TEST_SUITE(test_suite) {
	MU_RUN_TEST(test_check);
	MU_RUN_TEST(test_count);
}

/* Arguments are optional */
int main(int argc, char *argv[]) {
	MU_RUN_SUITE(test_suite);
	MU_REPORT();
	return 0;
}