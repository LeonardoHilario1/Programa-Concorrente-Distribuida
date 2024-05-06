package Entities;

import java.util.ArrayList;
import java.util.List;

import Aplication.Camareira;
import Aplication.Hospede;
import Aplication.Hotel;
import Aplication.Recepcionista;

public class HotelSimulation {

	public void startSimulation() {
		Hotel hotel = new Hotel();

		List<Thread> hospedes = new ArrayList<>();
		List<Thread> camareiras = new ArrayList<>();
		List<Thread> recepcionistas = new ArrayList<>();

		for (int i = 1; i <= 50; i++) {
			Hospede hospede = new Hospede("Hóspede " + i, hotel);
			Thread threadHospede = new Thread(hospede);
			hospedes.add(threadHospede);
			threadHospede.start();
		}

		for (int i = 0; i < 10; i++) {
			Camareira camareira = new Camareira(hotel);
			Thread threadCamareira = new Thread(camareira);
			camareiras.add(threadCamareira);
			threadCamareira.start();
		}

		for (int i = 0; i < 5; i++) {
			Recepcionista recepcionista = new Recepcionista(hotel);
			Thread threadRecepcionista = new Thread(recepcionista);
			recepcionistas.add(threadRecepcionista);
			threadRecepcionista.start();
		}
	}

	public static void main(String[] args) {
		HotelSimulation hotelSimulation = new HotelSimulation();
		hotelSimulation.startSimulation();
	}
}
