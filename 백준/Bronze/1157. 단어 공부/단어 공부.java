import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int alpa[] = new int[26];
		int max = 0;
		char maxAlpa = 0;
		String words = sc.next();
		
		for(int i=0; i<words.length(); i++)
			if((int)words.charAt(i) > 96)
				alpa[(int)words.charAt(i)-97]++;
			else 
				alpa[(int)words.charAt(i)-65]++;
		for(int i=0; i<26; i++)
			if(alpa[i] > max) {
				max = alpa[i];
				maxAlpa = (char)(i+65);
				}
			else if(alpa[i]==max)
				maxAlpa = '?';
		System.out.println(maxAlpa);

	}

}