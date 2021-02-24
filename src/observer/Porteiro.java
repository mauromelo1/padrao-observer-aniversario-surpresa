package observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Porteiro {

	private List<ChegadaAniversarianteObserver> observers = new ArrayList<>();

	public void addChegadaAniversarianteObserver(ChegadaAniversarianteObserver observer) {
		observers.add(observer);
	}

	public void monitorar() {
		Scanner sc = new Scanner(System.in);

		String valor = "";

		while (!"SAIR".equalsIgnoreCase(valor)) {
			System.out.println("Aniversariante chegou?");
			valor = sc.nextLine();

			if ("SIM".equalsIgnoreCase(valor)) {

				// Criar o evento
				ChegadaAniversarianteEvent event = new ChegadaAniversarianteEvent(new Date());

				// notificar os observadores!
				observers.stream().forEach(o -> o.chegou(event));

			} else {
				System.out.println("Alarme falso!");
			}

		}

		sc.close();
	} // fim monitorar
} // fim Porteiro
