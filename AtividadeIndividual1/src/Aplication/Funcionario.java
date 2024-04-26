package Aplication;

public class Funcionario {

	private final Conta salarioConta;
    private final Conta investimentoConta;
	
    public Funcionario(Conta salarioConta, Conta investimentoConta) {
        this.salarioConta = salarioConta;
        this.investimentoConta = investimentoConta;
    }

   
    public void run() {
        salarioConta.creditar(1400);
        double investimento = 0.2 * 1400;
        investimentoConta.creditar(investimento);
        System.out.println(Thread.currentThread().getName() + " recebeu salário de R$ 1400.00");
        System.out.println(Thread.currentThread().getName() + " investiu R$ " + investimento + " em sua conta de investimentos");
    }
}

