package bavaria.hightech.banking;

import java.text.DateFormat;

import bavaria.hightech.banking.Money.Currency;

public class Buchungsliste {

	private Buchung h;
	private Buchung pos;
	DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT);
	
	public Buchungsliste() {

		this.h = new Buchung(null, null, ' ', null, null);
		this.pos = h;
	}

	public void add(String reason, String amount, char sign, Currency currency) {

		Buchung obj = h;

		while (obj.getNext() != null)
			obj = obj.getNext();

		obj.creatNext(reason, amount, sign, null, currency);
	}

	public void clear() {
		this.h = new Buchung(null, null, ' ', null, null);
	}

	Buchung next() {

		if (pos.getNext() != null)
			this.pos = pos.getNext();

		else
			return null;

		return pos;
	}

	public void resetIteration() {
		this.pos = this.h;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Buchung lnk = h.getNext();
		while (lnk != null) {
			sb.append("> " + lnk.getReason() + ": " + lnk.getSign()
					+ lnk.getAmount() + " " + lnk.getCurrency() + " " + df.format(h.getBuchungdate().getTime()) + " " + tf.format(h.getBuchungdate().getTime()));
			sb.append('\n');
			lnk = lnk.getNext();
		}
		return sb.toString();
	}
}