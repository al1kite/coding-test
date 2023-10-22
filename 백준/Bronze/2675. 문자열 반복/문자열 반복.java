import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int i,j,k,l=0;
		char [][]repeatArr = new char [T][];
		
		for(i=0; i<T; i++) {
			int R = sc.nextInt();
			String s = sc.next();
			repeatArr[i] = new char[s.length()*R];
			for(j=0; j<s.length();j++)
				for(k=0; k<R;k++)
					repeatArr[i][l++] = s.charAt(j);
			l = 0;
		}
		for(i=0; i<T; i++) {
			for(j=0; j<repeatArr[i].length; j++) 
				System.out.print(repeatArr[i][j]);
			System.out.println();
		}
						
	}
		
}