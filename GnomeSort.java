public class GnomeSort {
	public int[] gnomeSort(int list[], int length) {
		int i = 0;
		while(i < length) {
			if(i == 0) i++;
			if(list[i] >= list[i - 1]) i++;
			else {
				list = swap(list, i, i - 1);
				i--;
			}
		}
		return list;
	}
	
	public int[] swap(int list[], int x, int y) {
		int temp = list[x];
		list[x] = list[y];
		list[y] = temp;
		return list;
	}
}
