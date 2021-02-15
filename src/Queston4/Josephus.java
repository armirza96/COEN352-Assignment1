package Queston4;

public class Josephus {

	public static void main(String[] args) {
		int n = 20;//8;//10;
		int k = 6;//3;//2;
		
		System.out.println("The safe position is: " + josephus(n,k));
		System.out.println("The safe position is (recursive): " + josephusRecursive(n,k));
	}
	
	private static int josephus(int numOfPpl, int killPosition) {
		/* explanation:
		 * this method takes in the number of ppl (n) in the circle and the position to kill the next person (M)
		 * The while loop continously executes until it reaches the last person
		 * the person killed on each iteration is the initial currentKilledPerson + the killposition
		 * so if n = 8, m = 3, then the first person killed is in position 3 (3 skips from including first person = 3rd person killed)
		 * to get the index of that person in the CIRCLE we take the modulus of that position since the currentKilledPosition variable
		 * only keeps track of the killed persons position relative to the beginning of the problem.
		 * By taking the modulus currentKilledPerson with respect to i we can keep track of the persons actual position and
		 * not the position as it increases through each iteration 
		 * time complexity: O(n)
		 */
		int currentKilledPerson = 1;
		for(int i = 1; i <= numOfPpl; i++) {
			currentKilledPerson = (currentKilledPerson + killPosition) % i  ;
		}
		
		return currentKilledPerson;
		
	}
	
	private static int josephusRecursive(int numOfPpl, int killPosition) {
		/* explanation:
		 * this is a recursive function that takes in two ints: number of ppl, and the kill position
		 * on first call we kill the Mth (killPosition) person starting at n = 0 (0 indexed)
		 * we then pass n - 1 people back into the function and the same kill position again.
		 * after each recursion finishes we need return index of the person who wasnt killed
		 * we compute this number by taking the last KILLED position and adding the killPosition
		 * this gives us the last person not killed in the circle.
		 * We then take the modulus of the result by the original amount of people to find the correct index
		 * of the person who survived
		 * This process is repeated until 1 people are left
		 * time complexity: O(n)
		 */
		return numOfPpl == 0 ? 0 : (josephusRecursive(numOfPpl - 1, killPosition) + killPosition) % numOfPpl;
	}
	
}
