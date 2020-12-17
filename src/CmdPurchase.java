public class CmdPurchase implements Command {
	@Override
	public String execute(VendingMachine v, String cmdPart) {
		// When Purchase is done make sure to move coinSlot to coinChanger
		String output = "Purchasing " + cmdPart + "... ";
		if (v.hasAmount(cmdPart)) {
			if (v.hasQuantity(cmdPart)) {
				if (!v.needChange(cmdPart)) {
					output += noChange(v);
					v.purchaseDrink(cmdPart);
				} else {
					if (v.hasChange(cmdPart)) {
						//return change and move coinslot to coin changer
						output += getChange(v, cmdPart);
						v.purchaseDrink(cmdPart);
					} else {
						output += insufficientChange();
					}
				}
			} else {
				output += noQuantity();
			}
		} else {
			output += insufficientAmount(v, cmdPart);
		}
		return output;
	}

	public String noQuantity() {
		return "Out of stock";
	}

	public String insufficientAmount(VendingMachine v, String name) {
		return "Insufficient amount! Inserted $" + v.getTotalCoinSlot() + " but needs $" + v.softDrinkPrice(name) + ".";
	}

	public String insufficientChange() {
		return "Insufficient change!";
	}

	public String noChange(VendingMachine v) {
		int totalCoin = v.getTotalCoinSlot();
		v.moveAllCoinToCoinChanger();
		return "Sucess! Paid $" + totalCoin + ". No change.";
		//we need to move coinslot to coinchanger
	}
	
	public String getChange(VendingMachine v, String name) {
		int totalCoin = v.getTotalCoinSlot();
		String change = v.returnChange(name);
		v.moveAllCoinToCoinChanger();
		return "Sucess! Paid $" + totalCoin + ". " + change;
	}
}