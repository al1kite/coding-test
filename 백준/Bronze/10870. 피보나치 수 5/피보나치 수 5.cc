#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int arr[21]={0,1,1,0};
int main()
{
	int n;
	scanf("%d", &n);

	for (int i = 3; i <= 20; i++)
	{
		arr[i] = arr[i - 1] + arr[i - 2];
	}

	if (n == 0)
		printf("%d", 0);
	else
		printf("%d", arr[n]);

	return 0;
}