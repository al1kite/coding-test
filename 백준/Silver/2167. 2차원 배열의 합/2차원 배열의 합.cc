#define _CRT_SECURE_NO_WARNINGS  
#include <stdio.h>
int main()
{
	int N, M, n;
	scanf("%d %d", &N, &M);
	int array[300][300] = { 0 };
	int sum[10000] = { 0 };
	int row1 = 0, row2 = 0, col1 = 0, col2 = 0;

	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			scanf("%d", &array[i][j]);
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d %d %d %d", &row1, &col1, &row2, &col2);
		for (int j = row1 - 1; j < row2; j++)
			for (int k = col1 - 1; k < col2; k++)
				sum[i] += array[j][k];
	}
	for (int i = 0; i < n; i++)
		printf("%d\n", sum[i]);

}