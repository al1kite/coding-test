
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		int num = sc.nextInt();
		int n = num;
		int add = 0; 
		int cnt = 0; 
		
		do {
			add = num/10 + num%10; 
			num = add%10 + num%10*10; 
			cnt++; 
		}while(n != num);
		
		System.out.print(cnt);
	}

}