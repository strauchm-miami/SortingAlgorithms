
public class BurntPancakeSortingWithMain {
	public int[] flip(int[] stack, int length) {
		int i = 0;
		if(length == 1 && stack[0] < 0) {
			stack[0] = stack[0] * -1;
			return stack;
		}
		while(i < length) {
			int temp = stack[i];
			stack[i] = stack[length];
			stack[length] = temp;
			length--;
			i++;
		}
		return stack;
	}
	
	public int MaxIndex(int[] stack, int end) {
		int temp = Integer.MIN_VALUE;
		int ret = -1;
		for(int i = 0; i < end; i++) {
			if(Math.abs(stack[i]) > temp) {
				ret = i;
				temp = Math.abs(stack[i]);
			}
		}
		return ret;
	}
	
	public int[] BurntPancakeSort(int[] stack) {
		int length = stack.length;
		while(length > 1) {
			int maxI = MaxIndex(stack, length);
			if(maxI != length) {
				stack = flip(stack, maxI);
				if(stack[0] < 0) stack = flip(stack, 1);
				stack = flip(stack, length-1);
			}
			length--;
		}
		return stack;
	}
	
	
	public static void print(int[] stack) {
		for(int i : stack)
			System.out.print(i + ", ");
		System.out.println();
	}
	
	public static void main (String args[]) {
		int[] test = {2, -4, 8, -3, 6};
		BurntPancakeSorting t = new BurntPancakeSorting();
		print(t.BurntPancakeSort(test));
	}
}
