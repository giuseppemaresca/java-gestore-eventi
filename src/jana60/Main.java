package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		// Inseriamo i dati della prenotazione e creiamo il primo evento
		boolean flag = false;
		String prenotazione;
		String disdetta;
		int giorno = 0;
		int mese = 0;
		int anno = 0;
		int capienza = 0;
		String titolo = null;
		LocalDate data = null;
		Evento e = null;
		Conferenze c = null;
		do {
			try {
				System.out.println("Inserisci il giorno della prenotazione ");
				giorno = Integer.parseInt(scan.nextLine());
				System.out.println("Inserisci il mese della prenotazione ");
				mese = Integer.parseInt(scan.nextLine());
				System.out.println("Inserisci l'anno della prenotazione ");
				anno = Integer.parseInt(scan.nextLine());
				data = LocalDate.of(anno, mese, giorno);
				System.out.println("Inserisci il nome dell'evento ");
				titolo = scan.nextLine();
				System.out.println("Inserisci la capienza dell'evento ");
				capienza = Integer.parseInt(scan.nextLine());
				e = new Evento(titolo, data, capienza);
				System.out.println(e);
				flag = true;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		} while (!flag);
//Chiediamo se è una conferenza. Se si inseriamo i dati della conferenza 

		System.out.println("Il tuo evento è una conferenza? Si/No ");
		String conferma = scan.nextLine();
		boolean flag1 = true;
		boolean flag2 = false;
		if (conferma.equalsIgnoreCase("Si")) {
			do {
				try {
					System.out.println(" Inserisci Argomento della conferenza:");
					String argom = scan.nextLine();
					System.out.println(" Inserisci Nome Oratore della conferenza :");
					String nomeOratore = scan.nextLine();
					System.out.println(" Inserisci Cognome Oratore della conferenza ");
					String cognomeOratore = scan.nextLine();
					System.out.println(" Inserisci titolo di studio dell'oratore :");
					String titoloOratore = scan.nextLine();
					Oratore or = new Oratore(nomeOratore, cognomeOratore, titoloOratore);
					c = new Conferenze(titolo, data, capienza, argom, or);
					flag1 = true;
					flag2 = false;
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			} while (flag2);
		}

		// Creazione programma per prenotazioni utente e disdette utenti con i flag 2-3

		boolean flag3 = true;
		int scelta = 0;
		do {

			System.out.println("Scrivi:(1): Prenota dei posti (2): Annulla dei posti  (3): Termina programma ");

			try {
				scelta = Integer.parseInt(scan.nextLine());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			switch (scelta) {
			case 1: {
				try {
					System.out.println("Quante prenotazioni vuoi fare?");
					int prenotazioni = Integer.parseInt(scan.nextLine());
					e.prenota(prenotazioni);
					System.out.println("Hai prenotato " + prenotazioni);
					System.out.println("Il totale delle tue prenotazioni è " + e.getNumeroPrenotati());
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

				break;
			}
			case 2: {
				try {
					System.out.println("Quante prenotazioni vuoi annullare?");
					int disd = Integer.parseInt(scan.nextLine());
					e.disdici(disd);
				} catch (NumberFormatException ex) {
					System.out.println(ex.getMessage());
				}
				break;
			}
			case 3: {
				flag3 = false;
				break;
			}
			default: {
				System.out.println("Scelta non valida, riprova.");
				break;
			}
			}
		} while (flag3);
//Print dell evento.
		System.out.println(e.toString());
		if (!flag2) {
			System.out.println(c.toString());
		}
		scan.close();

	}
}
