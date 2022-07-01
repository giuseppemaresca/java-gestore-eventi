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

	public int prenota() throws Exception {
		if (numeroPrenotati < 0)
			throw new Exception("Il numero di prenotazioni deve essere maggiore di 0");
		if (numeroTotale() < 0)

			throw new Exception("Posti finiti");
		else
			return numeroPrenotati += 1;

	}

	public int disdici() throws Exception {
		if (today.isAfter(data) || numeroPrenotati <= 0) {
			throw new Exception("Data superata o posti non validi");
		}
		return numeroPrenotati -= 1;
	}

	@Override

	public String toString() {
		return "La data dell'evento è : " + formatter.format(data) + " E il nome dell'evento : " + titolo;
	}

}
