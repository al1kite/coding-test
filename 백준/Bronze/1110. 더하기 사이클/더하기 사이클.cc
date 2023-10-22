#define _CRT_SECURE_NO_WARNINGS  
#include <stdio.h>
int main()
{
	int num = 0;
	scanf("%d", &num);
	int n = num;
	int add = 0;
	int cnt = 0;

	do {
		add = num / 10 + num % 10;
		num = add % 10 + num % 10 * 10;
		cnt++;
	} while (n != num);

	printf("%d",cnt);
}