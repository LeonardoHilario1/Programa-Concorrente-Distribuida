package Aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Hospede implements Runnable {
	private String nome;
	private Hotel hotel;

	public Hospede(String nome, Hotel hotel) {
		this.nome = nome;
		this.hotel = hotel;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(5));
			System.out.println(nome + " chegou ao hotel.");
			hotel.checkIn(this);
			TimeUnit.SECONDS.sleep(new Random().nextInt(5));
			hotel.checkOut(this);
			System.out.println(nome + " deixou o hotel.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
