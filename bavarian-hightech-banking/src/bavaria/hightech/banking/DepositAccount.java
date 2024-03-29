package bavaria.hightech.banking;

import java.util.Locale;
import java.util.ResourceBundle;

import bavaria.hightech.banking.Money.Currency;
import bavaria.hightech.exceptions.MoneyException;

/**
 * 
 * Deposit account with credit interest attributes -no negative amount-
 * 
 */

public class DepositAccount extends Account {

	/**
	 * DepositAccount()
	 * 
	 * @param interest
	 * @param kNumber
	 * @param kHolder
	 */
	public DepositAccount(int kNumber, String kHolder, DepositConditions fk) {

		super(kNumber, kHolder);
	}

	@Override
	public void payInterest(Locale currentLocale) throws MoneyException {

		ResourceBundle bank = ResourceBundle.getBundle("i18n/BankBundle",
				currentLocale);

		long amount = (long) ((this.getAccountBalance() / 100) * 2.34);
		this.manageMoney(bank.getString("interest"), amount, '+',
				this.kBalance.getCurrency());
	}

	@Override
	public void printTyp() {
		System.out.println("DepositAccount:");
	}

	/**
	 * set_kStand()
	 * 
	 * @param
	 */

	@Override
	public void manageMoney(String reason, long amount, char sign,
			Currency currency) throws MoneyException {
		Money money = new Money(amount, currency);

		if (sign == '-')
			if (this.getAccountBalance() - money.getValue() < 0) {

				throw new MoneyException("not enought money "
						+ getAccountBalance() + " " + money.getValue());
			}

		super.update(reason, amount, sign, currency);
	}
}