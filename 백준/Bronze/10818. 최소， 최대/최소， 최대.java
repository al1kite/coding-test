import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = -1000000, min = 1000000;
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int arr[] = new int[cnt];
		
		for(int i=0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] > max)
				max = arr[i];
			if(arr[i] < min)
				min = arr[i];
		}
		System.out.println(min+" "+max);
	}

}