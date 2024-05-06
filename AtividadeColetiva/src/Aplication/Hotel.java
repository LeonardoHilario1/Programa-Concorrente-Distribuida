package Aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Hotel {

	private final int NUM_QUARTOS = 10;
	private BlockingQueue<Hospede> filaEspera;
	private Quarto[] quartos;

	public Hotel() {
		filaEspera = new ArrayBlockingQueue<>(50);
		quartos = new Quarto[NUM_QUARTOS];
		for (int i = 0; i < NUM_QUARTOS; i++) {
			quartos[i] = new Quarto();
		}
	}

	public synchronized void checkIn(Hospede hospede) throws InterruptedException {
		filaEspera.put(hospede);
	}

	public synchronized void checkOut(Hospede hospede) {
		filaEspera.remove(hospede);
	}

	public synchronized Hospede getProximoHospede() throws InterruptedException {
		return filaEspera.poll(1, TimeUnit.SECONDS);
	}

	public synchronized Quarto getQuartoDisponivel() {
		for (Quarto quarto : quartos) {
			if (!quarto.isOcupado()) {
				return quarto;
			}
		}
		return null;
	}

	public synchronized Quarto getQuartoParaLimpar() throws InterruptedException {
		for (Quarto quarto : quartos) {
			if (quarto.isOcupado()) {
				return quarto;
			}
		}
		return null;
	}

	public synchronized boolean hasQuartoDisponivel() {
		for (Quarto quarto : quartos) {
			if (!quarto.isOcupado()) {
				return true;
			}
		}
		return false;
	}
}
