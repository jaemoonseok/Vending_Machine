import java.util.*;

public class VendingMachine {
	private ArrayList<Integer> coinChanger;
	private ArrayList<Integer> coinSlot;
	private ArrayList<SoftDrinkSlot> softDrinkSlots;

	public VendingMachine() {
		coinChanger = new ArrayList<Integer>();
		coinSlot = new ArrayList<Integer>();
		softDrinkSlots = new ArrayList<SoftDrinkSlot>();
	}

	public void addCoinToCoinChanger(Integer c) {
		coinChanger.add(c);
	}

	public void addSoftDrinkSlot(SoftDrinkSlot s) {
		softDrinkSlots.add(s);
	}

	// Used when Inserting a coin
	public void addCoinToCoinSlot(Integer c) {
		coinSlot.add(c);
	}

	/* You may add other non-static properties and methods */

	// Getter for rejecting coins
	public ArrayList<Integer> getcoinSlot() {
		return coinSlot;
	}
	
	// Used to get total coin in coin slot
	public int getTotalCoinSlot() {
		int sum = 0;
		for (int i : coinSlot) {
			sum += i;
		}
		return sum;
	}

	// Used to get total coin in coin changer
	public int getTotalCoinChanger() {
		int sum = 0;
		for (int i : coinSlot) {
			sum += i;
		}
		return sum;
	}

	// Used to move all coins from coin slot to coin changer after purchasing is
	// done
	public void moveAllCoinToCoinChanger() {
		coinChanger.addAll(coinSlot);
		coinSlot.clear();
	}

	// Take coins out in the coinsLot
	public String rejectCoin() {
		int total = getTotalCoinSlot();
		String output = "Rejected ";
		while (coinSlot.size() != 1) {
			int num = coinSlot.get(coinSlot.size() - 1);
			coinSlot.remove(coinSlot.size() - 1);
			output += "$" + num + ", ";
		}
		int num = coinSlot.get(0);
		coinSlot.remove(0);
		output += "$" + num + ". $" + total + " in Total.";
		return output;
	}

	public int softDrinkPrice(String name) {
		for (SoftDrinkSlot s : softDrinkSlots) {
			if (s.getName() == name) {
				return s.getPrice();
			}
		}
		return 0;
	}
	
	public void purchaseDrink(String name) {
		for (SoftDrinkSlot s : softDrinkSlots) {
			if (s.getName() == name) {
				s.purchase();
			}
		}
	}

	/*
	 * 
	 * From here it is used for Cmd Purchase
	 * 
	 */

	public boolean hasQuantity(String name) {
		for (SoftDrinkSlot s : softDrinkSlots) {
			if (s.getName() == name) {
				if (s.getQuantity() > 0) {
					return true;
				} else {
					return false;
				}
			}

		}
		return false;

	}

	public boolean hasAmount(String name) {
		for (SoftDrinkSlot s : softDrinkSlots) {
			if (s.getName() == name) {
				if (s.getPrice() <= getTotalCoinSlot()) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public boolean needChange(String name) {
		for (SoftDrinkSlot s : softDrinkSlots) {
			if (s.getName() == name) {
				if (s.getPrice() == getTotalCoinSlot()) {
					return false;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasChange(String name) {
		for (SoftDrinkSlot s : softDrinkSlots) {
			if (s.getName() == name) {
				int change = getTotalCoinSlot() - s.getPrice();
				ArrayList<ArrayList<Integer>> nList = countChange.sum_up(coinChanger, change);
				if (nList.size() != 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public String returnChange(String name) {
		ArrayList<Integer> n;
		String changes = "Change: ";
		for (SoftDrinkSlot s : softDrinkSlots) {
			if (s.getName() == name) {
				int change = getTotalCoinSlot() - s.getPrice();
				ArrayList<ArrayList<Integer>> nList = countChange.sum_up(coinChanger, change);
				maximumChange(nList);
				n = nList.get(0);
				for (int i = 0; i < n.size(); i++) {
					if (i == n.size() - 1) {
						changes += "$" + n.get(i) + ".";
						coinChanger.remove(n.get(i));
					} else {
						changes += "$" + n.get(i) + ", ";
						coinChanger.remove(n.get(i));
					}
				}
			}
		}
		return changes;
	}

	public void maximumChange(ArrayList<ArrayList<Integer>> nList) {
		while (nList.size() != 1) {
			for (int i = nList.get(0).size() - 1; i >= 0; i--) {
				int counter = nList.get(0).get(i);
				for (int j = 0; j < nList.get(0).size(); j++) {
					if (nList.get(j).get(i) > counter) {
						counter = nList.get(j).get(i);
					}
				}
				for (int k = 0; k < nList.get(0).size(); k++) {
					if (nList.get(k).get(i) < counter) {
						nList.remove(k);
					}
				}
			}
		}
	}
}
