package recursion;

public class TowerOfHanoi {
	
	public static void main(String[] args) {
		int source = 1;
		int helper = 2;
		int destination = 3;
		
		int disk = 3;
		solve(source, destination, helper, disk);
	}
	
	private static void solve(int source, int dest, int helper, int disk) {
		if(disk == 1) {
			System.out.println("Moving disk "+ disk +" from "+ source + " to "+ dest);
			return;
		}
		
		solve(source, helper, dest, disk -1);
		System.out.println("Moving disk "+ disk +" from "+ source + " to "+ dest);

		solve(helper, dest, source, disk-1);
	}
}
