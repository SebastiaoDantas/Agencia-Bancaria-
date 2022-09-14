package Program;

import java.util.ArrayList;
import java.util.Scanner;

public class BankBranch {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Account> bankAccounts;

	public static void main(String[] args) {
		bankAccounts = new ArrayList<Account>();
		operations();
	}

	public static void operations() {

		System.out.println("------------------------------------------------------");
		System.out.println("-------------🏦 Bem vindos a nossa Agência SAM 🏦---------------");
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma operação que deseja realizar *****");
		System.out.println("------------------------------------------------------");
		System.out.println("|   Opção 1 - Criar conta   |");
		System.out.println("|   Opção 2 - Depositar     |");
		System.out.println("|   Opção 3 - Sacar         |");
		System.out.println("|   Opção 4 - Transferir    |");
		System.out.println("|   Opção 5 - Listar        |");
		System.out.println("|   Opção 6 - Sair          |");

		int operation = input.nextInt();
		;

		switch (operation) {
		case 1:
			createAccount();
			break;

		case 2:
			deposit();
			break;

		case 3:
			towithdraw();
			break;

		case 4:
			transfer();
			break;

		case 5:
			listAccount();
			break;

		case 6:
			System.out.println("Obrigado por usar a nossa agencia, até mais 👋👋!!");
			System.exit(0); // para o sistema

		default:
			System.out.println("Opçao invalida!");
			operations();
			break;
		}
	}

	public static void createAccount() {
		// System.out.println("Você esta criando uma conta\n");

		System.out.println("\nNome: ");
		String name = input.next();

		System.out.println("\nCPF: ");
		String cpf = input.next();

		System.out.println("Email: ");
		String email = input.next();

		Person person = new Person(name, cpf, email);

		Account account = new Account(person);

		bankAccounts.add(account);
		System.out.println("--- Sua conta foi criada com sucesso✔️✔️! ---");
		operations();
	}

	private static Account findAccount(int numberAccount) {
		Account account = null;
		if (bankAccounts.size() > 0) {
			for (Account accountt : bankAccounts) {
				if (accountt.getNumberAccount() == numberAccount)
					account = accountt;
			}
		}
		return account;
	}

	public static void deposit() {
		System.out.println("Numero da conta: ");
		int numberAccount = input.nextInt();
		Account account = findAccount(numberAccount);

		if (account != null) {
			System.out.println("Qual valor deseja depositar? ");
			Double valueDeposit = input.nextDouble();

			account.deposit(valueDeposit);
		} else {
			System.out.println("--- Conta não encontrada ---");
		}

		operations();

	}

	public static void towithdraw() {
		System.out.println("Numero da conta: ");
		int numberAccount = input.nextInt();

		Account account = findAccount(numberAccount);

		if (account != null) {
			System.out.println("Qual valor deseja sacar? ");
			Double withdrawalValue = input.nextDouble();

			account.towithdraw(withdrawalValue);
			System.out.println("--- Saque realizado com sucesso! ---");
		} else {
			System.out.println("--- Conta não encontrada ---");
		}
		operations();
	}

	public static void transfer() {
		System.out.println("Número da conta que vai enviar a transferência: ");
		int senderAccountNumber = input.nextInt();

		Account senderAccount = findAccount(senderAccountNumber);

		if (senderAccount != null) {
			System.out.println("Numero da conta do destinatario: ");
			int numberAccountRecipient = input.nextInt();

			Account accountRecipient = findAccount(numberAccountRecipient);

			if (accountRecipient != null) {
				System.out.println("Valor da transferência: ");
				Double value = input.nextDouble();

				senderAccount.transfer(accountRecipient, value);

			} else {
				System.out.println("--- A conta para deposito não foi encontrada ---");
			}

		} else {
			System.out.println("--- Conta para transferência não encontrada ---");
		}
		operations();
	}

	public static void listAccount() {
		if (bankAccounts.size() > 0) {
			for (Account account : bankAccounts) {
				System.out.println(account);
			}
		} else {
			System.out.println("--- Não ha contas cadastradas ---");
		}
		operations();
	}
}
