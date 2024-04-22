package Aplication;

public class ClienteRunnable implements Runnable {
	
	    private Cliente cliente;

	    public ClienteRunnable(Cliente cliente) {
	        this.cliente = cliente;
	    }

	  
	    public void run() {
	        cliente.run(); 
	    }
	}


