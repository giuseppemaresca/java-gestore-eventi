package jana60;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Evento {
//attributi
	private String titolo;
	private LocalDate data;
	private LocalDate today = LocalDate.now();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private int numeroCapienza;
	private int numeroPrenotati;

//Costruttore
	public Evento(String titolo, LocalDate data, int numeroCapienza) throws Exception {
		super();
		this.titolo = titolo;
		this.data = data;
		this.numeroCapienza = numeroCapienza;
		this.numeroPrenotati = 0;
		validazioneData();
		validazioneCapienza();
	}

//Getter e setter
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getNumeroCapienza() {
		return numeroCapienza;
	}

	public int getNumeroPrenotati() {
		return numeroPrenotati;
	}

	public int numeroTotale() {

		return numeroCapienza - numeroPrenotati;
	}

	public void validazioneData() throws Exception {
		if (today.isAfter(data)) {
			throw new Exception("Inserisci una data valida");
		}
	}

	public void validazioneCapienza() throws Exception {
		if (numeroCapienza <= 0)
			throw new Exception("La capienza deve essere valida");

	}

	public int prenota(int prenotazioni) throws Exception {
		if (numeroPrenotati > numeroCapienza)
			throw new Exception("Il numero di prenotazioni deve essere inferiore rispetto alla capienza");
		if (numeroPrenotati < 0) {
			throw new Exception("Numero non valido");
		}

		return numeroPrenotati += prenotazioni;

	}

	public int disdici(int disdetta) throws Exception {
		if (today.isAfter(data) || numeroPrenotati <= 0) {
			throw new Exception("Data superata o i posti che vuoi disdire sono superiori ai posti prenotati! ");
		}
		return numeroPrenotati -= 1;
	}

	@Override

	public String toString() {
		return "La data dell'evento è : " + formatter.format(data) + " E il nome dell'evento : " + titolo;
	}

}
