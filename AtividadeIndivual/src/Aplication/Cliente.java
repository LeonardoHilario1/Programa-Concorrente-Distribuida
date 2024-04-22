package Aplication;

public class Cliente {
	 private final Conta conta;

	    public Cliente(Conta conta) {
	        this.conta = conta;
	    }

	
	    public void run() {
	        while (conta.getSaldo() > 0) {
	            double valor = Math.random() > 0.5 ? 100 : 200;
	            conta.debitar(valor);
	            System.out.println(Thread.currentThread().getName() + " realizou compra de R$ " + valor);
	        }
	    }


		
			
		}
	

