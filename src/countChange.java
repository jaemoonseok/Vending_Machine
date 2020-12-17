import java.util.*;

class countChange {
	static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial,
			ArrayList<ArrayList<Integer>> nList) {
		int s = 0;
		for (int x : partial)
			s += x;
		if (s == target)
			nList.add(partial);
		if (s >= target)
			return;
		for (int i = 0; i < numbers.size(); i++) {
			ArrayList<Integer> remaining = new ArrayList<Integer>();
			int n = numbers.get(i);
			for (int j = i + 1; j < numbers.size(); j++)
				remaining.add(numbers.get(j));
			ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
			partial_rec.add(n);
			sum_up_recursive(remaining, target, partial_rec, nList);
		}
	}

	static ArrayList<ArrayList<Integer>> sum_up(ArrayList<Integer> numbers, int target) {
		ArrayList<ArrayList<Integer>> nList = new ArrayList<ArrayList<Integer>>();
		sum_up_recursive(numbers, target, new ArrayList<Integer>(), nList);
		for (ArrayList<Integer> n : nList) {
			Collections.sort(n);
		}
		if (nList.size() == 0) {
			return nList;
		} else {
			int counter = nList.get(0).size();
			for (ArrayList<Integer> n : nList) {
				if (n.size() < counter) {
					counter = n.size();
				}
			}

			for (ArrayList<Integer> n : nList) {
				if (n.size() > counter) {
					nList.remove(n);
				}
			}
			return nList;
		}
	}
}
