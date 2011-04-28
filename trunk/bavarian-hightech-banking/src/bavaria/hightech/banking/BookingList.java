package bavaria.hightech.banking;

import java.text.DateFormat;
import java.util.ArrayList;

import bavaria.hightech.banking.Money.Currency;

/**
 *
 * class to manage the booking
 *
 */
public class BookingList {

	DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT);
	
	ArrayList<Accounting> accounting = new ArrayList<Accounting>();
	
	/**
	 * add()
	 * @param reason
	 * @param amount
	 * @param sign
	 * @param currency
	 */
	public void add(String reason, String amount, char sign, Currency currency){
		
		this.accounting.add( new Accounting(reason,amount,sign,currency) );
	}
	
	/**
	 * clear()
	 * -empty the booking list
	 */
	public void clear(){
		
		this.accounting = new ArrayList<Accounting>();
	}
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		for(Accounting lnk : this.accounting){
			sb.append("> " + lnk.getReason() + ": " + lnk.getSign()
					+ lnk.getAmount() + " " + lnk.getCurrency() + " "
					+ df.format(lnk.getAccountingDate().getTime()) + " "
					+ tf.format(lnk.getAccountingDate().getTime()));
			sb.append('\n');			
		}
		
		return sb.toString();
	}
}