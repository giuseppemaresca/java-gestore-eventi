package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		// Inseriamo i dati della prenotazione
		boolean flag = false;
		String prenota;
		String disdici;

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
				Evento e = new Evento(titolo, data, capienza);
				System.out.println(e);
				flag = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!flag);
		System.out.println("Inserisci il numero di prenotazioni ");
		int prenot = Integer.parseInt(scan.nextLine());

	}
}
