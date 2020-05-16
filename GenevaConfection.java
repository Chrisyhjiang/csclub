// https://dmoj.ca/problem/ccc14s3 Geneva Confection
import java.util.*;
public class GenevaConfection {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		// get cursor to next line
		scanner.nextLine();
		String[] answer = new String[n];
		for (int i = 0; i<n; i++) {
			int m = scanner.nextInt();
			scanner.nextLine();
			int[] mountain = new int[m];
			for (int j = 0; j < m; j++) {
				// Processing input
				mountain[j] = scanner.nextInt();
			}
			
			answer[i] = hasPath(mountain);
		}
		scanner.close();
		for(int k = 0; k < answer.length; k++) {
			System.out.println(answer[k]);
		}
	}
		
	public static String hasPath(int[] mountain) {
		Stack<Integer> branch = new Stack<Integer>();
		int num = 1;
		String answer = "Y";
		for (int i = mountain.length-1; i >= 0; i--) {
			// if mountain equals num, then num add 1
			if (mountain[i] == num) {
				num++;
			}
			// if the branch is not empty and the number = the peek value
			// we then add 1 to number
			else if (!branch.empty() && num == branch.peek()) {
				num++;
				// we have to negate the index from advancing by adding 1
				i++;
				branch.pop();
			}
			else {
				branch.push(mountain[i]);
			}
		}
		
		while(!branch.empty()) {
			int next = branch.peek();
			if (next == num) {
				num++;
				branch.pop();
			}
			// if next does not equall number than answer is "No"
			else {
				answer = "N";
				break;
			}

			}
		
		
		return answer;
	}
			
	}