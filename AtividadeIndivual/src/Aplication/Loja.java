package Aplication;

import java.util.ArrayList;
import java.util.List;

public class Loja {
	private final Conta conta;
    private final List<Funcionario> funcionarios;

    public Loja(Conta conta, int numFuncionarios) {
        this.conta = conta;
        this.funcionarios = new ArrayList<>();
        for (int i = 0; i < numFuncionarios; i++) {
            Conta salarioConta = new Conta(0);
            Conta investimentoConta = new Conta(0);
            Funcionario funcionario = new Funcionario(salarioConta, investimentoConta);
            funcionarios.add(funcionario);
            Thread threadFuncionario = new Thread();
            threadFuncionario.start();
        }
    }

    public void pagarSalarios() {
        double totalSalarios = funcionarios.size() * 1400;
        conta.creditar(totalSalarios);
        System.out.println("Salários dos funcionários pagos com sucesso!");
	    }
	}

