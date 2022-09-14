package Program;

public class Person {
	
	private static int counter = 1;
	
	private	String name;
	private String cpf;
	private String email;
	
	public Person(String name, String cpf, String email) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		counter += 1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	  
	public String toString() {
		return "\nNome: " + this.getName() +
				"\nCPF: " + this.getCpf() +
				"\nEmail " + this.getEmail();
	}
	
}
