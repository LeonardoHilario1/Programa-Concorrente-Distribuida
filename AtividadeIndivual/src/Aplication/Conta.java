package Aplication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conta {

	 private double saldo;
	    private final Lock lock;

	    public Conta(double saldo) {
	        this.saldo = saldo;
	        this.lock = new ReentrantLock();
	    }

	    public double getSaldo() {
	        return saldo;
	    }

	    public void debitar(double valor) {
	        lock.lock();
	        try {
	            saldo -= valor;
	        } finally {
	            lock.unlock();
	        }
	    }

	    public void creditar(double valor) {
	        lock.lock();
	        try {
	            saldo += valor;
	        } finally {
	            lock.unlock();
	        }
	    }
	}

