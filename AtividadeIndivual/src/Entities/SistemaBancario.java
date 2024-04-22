package Entities;

import java.util.ArrayList;
import java.util.List;

import Aplication.Banco;
import Aplication.Cliente;
import Aplication.ClienteRunnable;
import Aplication.Conta;
import Aplication.Loja;

public class SistemaBancario {

	public static void main(String[] args) {
		
		Conta contaBanco = new Conta(100000); 
	    Conta contaLoja1 = new Conta(0);
	    Conta contaLoja2 = new Conta(0);

	    Banco banco = new Banco();
	    Loja loja1 = new Loja(contaLoja1, 2);
	    Loja loja2 = new Loja(contaLoja2, 2);

	    List<Cliente> clientes = new ArrayList<>();
	    List<Thread> threadsClientes = new ArrayList<>(); 
	    for (int i = 0; i < 5; i++) {
	        Conta contaCliente = new Conta(1000);
	        Cliente cliente = new Cliente(contaCliente);
	        clientes.add(cliente);
	        ClienteRunnable clienteRunnable = new ClienteRunnable(cliente); 
	        Thread threadCliente = new Thread(clienteRunnable);
	        threadsClientes.add(threadCliente); 
	        threadCliente.start(); 
	    }
	    

	    for (Thread threadCliente : threadsClientes) { 
	        try {
	            threadCliente.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    loja1.pagarSalarios();
	    loja2.pagarSalarios();

	    System.out.println("Saldo final do banco: R$ " + contaBanco.getSaldo());
	    System.out.println("Saldo final da loja 1: R$ " + contaLoja1.getSaldo());
	    System.out.println("Saldo final da loja 2: R$ " + contaLoja2.getSaldo());
	}
	}


