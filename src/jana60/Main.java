package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		// Inseriamo i dati della prenotazione
		boolean flag = false;
		String prenotazione;
		String disdetta;
		Evento e = null;
		do {
			try {
				System.out.println("Inserisci il giorno della prenotazione ");
				int giorno = Integer.parseInt(scan.nextLine());
				System.out.println("Inserisci il mese della prenotazione ");
				int mese = Integer.parseInt(scan.nextLine());
				System.out.println("Inserisci l'anno della prenotazione ");
				int anno = Integer.parseInt(scan.nextLine());
				LocalDate data = LocalDate.of(anno, mese, giorno);
				System.out.println("Inserisci il nome dell'evento ");
				String titolo = scan.nextLine();
				System.out.println("Inserisci la capienza dell'evento ");
				int capienza = Integer.parseInt(scan.nextLine());
				e = new Evento(titolo, data, capienza);
				System.out.println(e);
				flag = true;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		} while (!flag);

		boolean chiudi = false;

		System.out.println("Inserisci 1 per prenotare / 2 per terminare ");
		prenotazione = scan.nextLine();
		switch (prenotazione) {
		case "1": {
			System.out.println("Inserisci quante prenotazioni vuoi effettuare ");
			int prenot = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < prenot; i++)

				e.prenota();
			System.out.println("I posti che hai prenotato sono : " + e.getNumeroPrenotati()
					+ " e la disponibilità rimasta è : " + e.numeroTotale());
			break;
		}
		case "2": {
			System.out.println("Grazie e arrivederci");
			chiudi = true;
		}

		}

		System.out.println("Inserisci 1 se vuoi annullare delle prenotazioni /2 per terminare ");
		disdetta = scan.nextLine();
		switch (disdetta) {
		case "1": {
			System.out.println("Inserisci quanti posti vuoi togliere ");
			int disd = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < disd; i++)

				e.disdici();
			System.out.println("I posti che hai tolto sono " + disd + " I posti che hai prenotato sono "+e.getNumeroPrenotati()+" e la disponibilità rimasta è : "
					+ e.numeroTotale());
			break;
		}
		case "2": {
			System.out.println("Grazie e arrivederci");
			chiudi = true;
		}

		}

	}

}
