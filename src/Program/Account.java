package Program;

public class Account {

	// Contador de contas
	private static int accountAccountant = 1;

	private int numberAccount;
	private Person person;
	private Double balance = 0.0;

	public Account(Person person) {
		this.numberAccount = accountAccountant;
		this.person = person;
		accountAccountant += 1;
	}

	public int getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(int numberAccount) {
		this.numberAccount = numberAccount;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String toString() {
		return "\nNumero da conta: " + this.getNumberAccount() + "\nNome: " + this.person.getName() + "\nCPF: "
				+ this.person.getCpf() + "\nEmail: " + this.person.getEmail() + "\nSaldo: "
				+ Utils.doubleToString(this.getBalance()) + "\n";
	}

	// Metodo Depositar
	public void deposit(Double value) {
		if (value > 0) {
			setBalance(getBalance() + value);
			System.out.println("Seu deposito foi realizado com sucesso! 🤑");
		} else {
			System.out.println("Não foi possivel realizar o deposito! 😓");
		}
	} 

	// Metodo Saque
	public void towithdraw(Double value) {
		if (value > 0 && this.getBalance() >= value) {
			setBalance(getBalance() - value);
			System.out.println("Saque realizado com sucesso! 🤑");
		} else {
			System.out.println("Não foi possivel realizar o saque! 😓");
		}
	}

	// Metodo Transfere
	public void transfer(Account accountFordeposit, Double value) {
		if (value > 0 && this.getBalance() >= value) {
			setBalance(getBalance() - value);

			accountFordeposit.balance = accountFordeposit.getBalance() + value;
			System.out.println("Transferencia realizada com sucesso! 🤑");
		} else {
			System.out.println("Não foi possivel relizar a transferencia! 😓");
		}
	}

}
