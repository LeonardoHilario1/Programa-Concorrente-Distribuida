package Aplication;

public class Banco {
	public void transferir(double valor, Conta origem, Conta destino) {
        origem.debitar(valor);
        destino.creditar(valor);
        System.out.println("Transferência de R$ " + valor + " realizada com sucesso.");
    }
}
	

