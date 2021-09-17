public class TournamentSort {
	public static int[] tournamentSort(int[] list) {
		int length = list.length;
		int ret[] = new int[length];

		int[] tree = new int[treeSize(length)];
		int retI = ret.length - 1;
		
		int treeI = tree.length - 1;
		for(int i = length - 1; i >= 0; i--) {
			tree[treeI--] = list[i];
		}
		while(retI >= 0) {			
			for(int i = tree.length / 2 - 1; i > 0; i--) {
				if(tree[i] < tree[i*2] || tree[i] < tree[(i*2) + 1]) {
					if(tree[i*2] >= tree[(i*2)+1]) {
						tree[i] = tree[i*2];
					}
					else {
						tree[i] = tree[(i*2)+1];
					}
				}
			}
			ret[retI--] = tree[1];
			list = review(list, tree[1]);
			tree = review(tree, tree[1]);
		}
		return ret;
	}
	public static int max(int x, int y) {
		return ((x > y) ? x : y);
	}
	public static int[] review(int[] list, int n) {
		for(int i = 0; i < list.length; i++) 
			if(list[i] == n) list[i] = Integer.MIN_VALUE;
		return list;
	}
	public static int treeSize(int n) {
		int sqr = 1;
		while(n > sqr) {
			sqr = sqr * 2;
		}
		int ret = sqr;
		while(sqr != 0) {
			ret += (sqr / 2);
			sqr = sqr / 2;
		}
		return ++ret;
	}
}
