#include <stdio.h>

void sort(int *array, long int size) {

	for (int i = 0; i < size; i++) {
		int end = 1;
		for (int j =0; j < size-1; j++) {
			if (array[j] > array[j+1]) {
				int temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				end = 0;
			}
		}
		if (end) break;
	}

}

int main(void) {
	int nums[] = {4, 6, 22, 11, 5, 7, 2, 1, 4, 3, 9, 7, 6, 8, 43, 12, 54, 34, 423, 543, 123, 32, 321, 75, 43, 6, 5, 1};

	long int n = sizeof(nums) / sizeof(nums[0]);

	sort(nums, n);

	for (int i = 0; i < n; i++) {
		printf("%d ", nums[i]);
	}

	printf("\n");

}
