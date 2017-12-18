#include "minunit.h"
#include "../C/Linked_Lists/methods.h"
#include "test_length.h"
#include "test_frequency.h"

/* Arguments are optional */
int main(int argc, char *argv[]) {
	MU_RUN_SUITE(length);
	MU_RUN_SUITE(freq);
	MU_REPORT();
	return 0;
}