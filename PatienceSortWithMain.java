public class PatienceSortWithMain {
	public static int[] patienceSort(int[] list) {
		int[][] stacks = new int[list.length][list.length];
		int[] count = new int[list.length];
		stacks[0][0] = list[0];
		count[0]++;
		
		int x = 0;
		boolean run = false;
		for(int i = 1; i < list.length; i++) {
			run = false;
			x = 0;
			while(!run) {
				if(count[x] > 0 && list[i] < stacks[x][count[x] - 1]) {
					stacks[x][count[x]] = list[i];
					count[x] = count[x] + 1;
					run = true;
				}
				else if(stacks[x][count[x]] == 0 && count[x] == 0){
					stacks[x][count[x]] = list[i];
					count[x] = count[x] + 1;					
					run = true;
				}
				else {
					x++;
				}
			}
		}
		return combine(stacks, count);
	}
	
	public static int[] combine(int[][] stacks, int[] count) {
		int[] ret = new int[count.length];
		int done = 0;
		int temp = 0;
		int min = Integer.MAX_VALUE;
		while(done < count.length) {
			min = Integer.MAX_VALUE;
			for(int i = 0; i < count.length; i++) {
				if(count[i] > 0 && stacks[i][count[i] - 1] != 0 && stacks[i][count[i] - 1] < min) {
					min = stacks[i][count[i] - 1];
					temp = i;
				}
			}
			count[temp] = count[temp] - 1;
			ret[done++] = min;
		}
		return ret;
	}

	public static void print(int[] list) {
		for(int i = 0; i < list.length; i++)
			System.out.print(list[i] + ", ");
		System.out.println();
	}
	
	public static void main(String args[]) {
		int[] test = {2, 8, 3, 7, 4};
		test = patienceSort(test);
		print(test);
	}
}
