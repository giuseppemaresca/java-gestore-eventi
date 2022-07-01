package jana60;

import java.time.LocalDate;

public class Conferenze extends Evento {

	private String argomento;
	private Oratore oratore;

	public Conferenze(String titolo, LocalDate data, int numeroCapienza, String argomento, Oratore oratore)
			throws Exception {
		super(titolo, data, numeroCapienza);
		this.argomento = argomento;
		this.oratore = oratore;
	}

	@Override
	public String toString() {
		return "Nome oratore: " + oratore.getNome() + " Cognome oratore: " + oratore.getCognome() + " Titolo: "
				+ oratore.getTitolo() + "Argomento: " + argomento;
	}
}
