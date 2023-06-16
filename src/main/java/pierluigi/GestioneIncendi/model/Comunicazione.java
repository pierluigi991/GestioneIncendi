package pierluigi.GestioneIncendi.model;

import org.slf4j.*;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Comunicazione extends CanaleComunicazione {

	private static final Logger Logger = LoggerFactory.getLogger(Comunicazione.class);

	public void sendInfo(Long idSonda, double latitude, double longitude, int fumo) {
		Logger.info("Sonda attiva: " + idSonda + " Latitudine: " + latitude + " Longitudine: " + longitude + " Livello fumo: "
				+ fumo);

	}

}
