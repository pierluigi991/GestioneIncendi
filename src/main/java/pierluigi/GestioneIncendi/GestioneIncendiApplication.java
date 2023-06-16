package pierluigi.GestioneIncendi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.extern.slf4j.Slf4j;
import pierluigi.GestioneIncendi.model.ControlloSonda;
import pierluigi.GestioneIncendi.model.CentroControlloProxy;
import pierluigi.GestioneIncendi.model.Sonda;

@Slf4j
@SpringBootApplication
public class GestioneIncendiApplication {

	private static ControlloSonda controlloSondaLecce;
	private static ControlloSonda controlloSondaBari;
	private static ControlloSonda controlloSondaMiggiano;

	private static CentroControlloProxy controlloLecce;
	private static CentroControlloProxy controlloBari;
	private static CentroControlloProxy controlloMiggiano;

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendiApplication.class, args);

		Sonda Lecce = new Sonda();
		Lecce.setId(1l);
		Lecce.setLatitude(40.351515);
		Lecce.setLongitude(18.175016);
		Lecce.setSmokeLevel(5);

		Sonda Bari = new Sonda();
		Bari.setId(2l);
		Bari.setLatitude(41.117143);
		Bari.setLongitude(16.871871);
		Bari.setSmokeLevel(8);

		Sonda Miggiano = new Sonda();
		Miggiano.setId(3l);
		Miggiano.setLatitude(39.9608);
		Miggiano.setLongitude(18.3125 );
		Miggiano.setSmokeLevel(2);

		controlloLecce = new CentroControlloProxy();
		controlloBari = new CentroControlloProxy();
		controlloMiggiano = new CentroControlloProxy();

		controlloSondaLecce = new ControlloSonda(1l, controlloLecce);
		controlloSondaBari = new ControlloSonda(1l, controlloBari);
		controlloSondaMiggiano = new ControlloSonda(1l, controlloMiggiano);

		Lecce.addObserver(controlloSondaLecce);
		Bari.addObserver(controlloSondaBari);
		Miggiano.addObserver(controlloSondaMiggiano);

		if (Lecce.getSmokeLevel() > Lecce.SMOKE_LIMIT) {
			log.info("Allarme incendio a Lecce!");
			controlloSondaLecce.update(Lecce);
		}

		if (Bari.getSmokeLevel() > Bari.SMOKE_LIMIT) {
			log.info("Allarme incendio a Bari!");
			controlloSondaBari.update(Bari);
		}

		if (Miggiano.getSmokeLevel() > Miggiano.SMOKE_LIMIT) {
			log.info("Allarme incendio a Miggiano!");
			controlloSondaMiggiano.update(Miggiano);
		}

	}

}
