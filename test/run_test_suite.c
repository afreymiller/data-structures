#include "minunit.h"
#include "../C/Linked_Lists/methods.h"
#include "test_length.h"
#include "test_frequency.h"
#include "test_get_nth.h"
#include "test_push.h"

/* Arguments are optional */
int main(int argc, char *argv[]) {
	MU_RUN_SUITE(length);
	MU_RUN_SUITE(freq);
	MU_RUN_SUITE(get_nth_suite);
	MU_RUN_SUITE(push_suite);
	MU_REPORT();
	return 0;
}