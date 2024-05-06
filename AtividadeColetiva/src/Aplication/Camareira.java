package Aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Camareira extends Thread {
	private Hotel hotel;

	public Camareira(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Quarto quarto = hotel.getQuartoParaLimpar();
				if (quarto != null) {
					TimeUnit.SECONDS.sleep(new Random().nextInt(5));
					quarto.checkOut();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
