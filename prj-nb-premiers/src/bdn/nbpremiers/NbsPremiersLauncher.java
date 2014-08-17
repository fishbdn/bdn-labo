package bdn.nbpremiers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bdn.nbpremiers.service.impl.NbPremiersService;
import bdn.nbpremiers.util.TimerUtils;

public class NbsPremiersLauncher {

	private static Logger LOGGER = LoggerFactory.getLogger(NbsPremiersLauncher.class);

	public static void main(String[] args) {

		if (args == null) {
			LOGGER.error("Parametrage incorrecte !");
		}

		Date start = new Date();
		
		long startNb = 0x0001L;
		long toNb = 0x1000000L;
		
		boolean displayNumbers = true;
		
		NbPremiersService service = NbPremiersService.getInstance();
		
		LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		LOGGER.info("> Debut du traitement {}",	NbsPremiersLauncher.class.getCanonicalName());
		LOGGER.info("> Debut : {}", TimerUtils.dateFormatter(start));
		LOGGER.info("> Plage de recheche : [ {} -> {} ]",startNb, toNb);
		LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

//		LOGGER.info("{} premiers trouvés !!", service.chercheClassicalApproach(startNb, toNb, displayNumbers));
		LOGGER.info("{} premiers trouvés !!", service.chercheOptimSquareApproach(startNb, toNb, displayNumbers, null));
		
//		LOGGER.info("{} premiers trouvés !!", service.chercheOptimEratostheneWithLongApproach(startNb, toNb, displayNumbers));

		LOGGER.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		LOGGER.info("> Fin du traitement NombresPremiers");
		LOGGER.info("> Fin : {}", TimerUtils.dateFormatter(new Date()));
		LOGGER.info("> Duree : {}", TimerUtils.timerFormatter(start.getTime()));
		LOGGER.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	

}
