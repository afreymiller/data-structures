#include "minunit.h"
#include "../C/Linked_Lists/methods.h"

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

MU_TEST(test_freq_1) {
	int freq;
	node* list = build_one_two_three();
	freq = get_frequency(list, 1);
	mu_check(freq == 1);
}

MU_TEST(test_freq_empty) {
	int freq;
	node* list = build_one_two_three();
	freq = get_frequency(list, 0);
	mu_check(freq == 0);
}

MU_TEST(test_freq_2) {
	int freq; 
	node* list = build_one_two_three();
	push(&list, 2);
	freq = get_frequency(list, 2);
	mu_check(freq == 2);
}

MU_TEST_SUITE(length) {
	MU_RUN_TEST(test_length_init);
	MU_RUN_TEST(test_length_add_1);
	MU_RUN_TEST(test_length_add_2);
}

MU_TEST_SUITE(freq) {
	MU_RUN_TEST(test_freq_1);
	MU_RUN_TEST(test_freq_empty);
	MU_RUN_TEST(test_freq_2);
}

/* Arguments are optional */
int main(int argc, char *argv[]) {
	MU_RUN_SUITE(length);
	MU_RUN_SUITE(freq);
	MU_REPORT();
	return 0;
}