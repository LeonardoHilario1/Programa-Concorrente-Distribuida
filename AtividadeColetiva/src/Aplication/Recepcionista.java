package Aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Recepcionista extends Thread {
	private Hotel hotel;

	public Recepcionista(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Hospede hospede = hotel.getProximoHospede();
				if (hospede != null) {
					Quarto quarto = hotel.getQuartoDisponivel();
					if (quarto != null) {
						quarto.checkIn(hospede);
					} else {
						System.out.println("Todos os quartos estão ocupados. " + hospede.getNome() + " aguardando...");
						TimeUnit.SECONDS.sleep(new Random().nextInt(5));
						if (!hotel.hasQuartoDisponivel()) {
							System.out.println(hospede.getNome() + " não conseguiu um quarto. Deixando o hotel.");
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
