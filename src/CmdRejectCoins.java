import java.util.*;

public class CmdRejectCoins implements Command {
	@Override
	public String execute(VendingMachine v, String cmdPart) {
		String output = "";
		if (v.getcoinSlot().size() == 0) {
			output = "Rejected no coin!";
		} else {
			output = v.rejectCoin();
		}
		
		return output;
	}
}