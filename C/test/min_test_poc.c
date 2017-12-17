#include "minunit.h"

MU_TEST(test_check) {
	mu_check(7 == 7);
}

MU_TEST_SUITE(test_suite) {
	MU_RUN_TEST(test_check);
}

/* Arguments are optional */
int main(int argc, char *argv[]) {
	MU_RUN_SUITE(test_suite);
	MU_REPORT();
	return 0;
}