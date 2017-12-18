#include "minunit.h"

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

MU_TEST_SUITE(freq) {
	MU_RUN_TEST(test_freq_1);
	MU_RUN_TEST(test_freq_empty);
	MU_RUN_TEST(test_freq_2);
}