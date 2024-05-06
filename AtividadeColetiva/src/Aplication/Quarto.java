package Aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Quarto {
	private final int capacidadeMaxima = 4;
	private boolean ocupado;
	private List<Hospede> hospedes;

	public Quarto() {
		this.ocupado = false;
		this.hospedes = new ArrayList<>();
	}

	public synchronized boolean isOcupado() {
		return ocupado;
	}

	public synchronized boolean checkIn(Hospede hospede) {
		if (!ocupado && hospedes.size() < capacidadeMaxima) {
			hospedes.add(hospede);
			ocupado = true;
			System.out.println(hospede.getNome() + " fez check-in no quarto.");
			return true;
		}
		return false;
	}

	public synchronized void checkOut() {
		ocupado = false;
		hospedes.clear();
		System.out.println("Quarto foi liberado.");
	}

}
