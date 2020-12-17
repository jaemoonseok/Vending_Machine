public class CmdInsertCoin implements Command {
	@Override
	public String execute(VendingMachine v, String cmdPart) {
		Integer coin = Integer.valueOf(cmdPart);
		v.addCoinToCoinSlot(coin);
		return "Inserted a $" + coin + " coin. $" + v.getTotalCoinSlot() + " in Total.";
	}
}