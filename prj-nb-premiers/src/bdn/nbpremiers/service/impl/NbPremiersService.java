package bdn.nbpremiers.service.impl;

import javax.swing.JProgressBar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bdn.nbpremiers.util.NbPremiersCalculatorUtils;
import bdn.nbpremiers.util.NbPremiersCalculatorUtils.Eratosthenes2;

/**
 * TODO
 * @author bdn
 *
 */
public class NbPremiersService {

	Logger LOGGER = LoggerFactory.getLogger(NbPremiersService.class);
	
	// Instance singleton
	private static NbPremiersService instance = new NbPremiersService();
	
	
	private NbPremiersService() {
		// Constructeur inaccessible (car singleton)
	}


	public static NbPremiersService getInstance() {
		return instance;
	}
	
	

	public int chercheClassicalApproach(long nbDebut, long nbFin, boolean displayTrace, JProgressBar bar) {
		int nbFound = 0;
		if (bar != null) {
			try {
				Integer mxInt = new Integer(""+nbFin);
				bar.setMaximum(mxInt);
			} catch (Exception e) {
				LOGGER.error("Probleme lors de l'initialisation de la barre de progression", e);
				bar = null;
			}
		}
		
		for (long i = nbDebut; i <= nbFin; i++) {
			if (NbPremiersCalculatorUtils.Classical.isNombrePremier(i)) {
				if (displayTrace) LOGGER.info("> Nombre 1er : {}", i);
				nbFound++;
				if (bar!=null) bar.setValue(new Integer(""+i));
			}
		}
		return nbFound;
	}

	public int chercheOptimSquareApproach(long nbDebut, long nbFin, boolean displayTrace, JProgressBar bar) {
		int nbFound = 0;
		
		if (bar != null) {
			try {
				Integer mxInt = new Integer(""+nbFin);
				bar.setMaximum(mxInt);
			} catch (Exception e) {
				LOGGER.error("Probleme lors de l'initialisation de la barre de progression", e);
				bar = null;
			}
		}
		
		for (long i = nbDebut; i <= nbFin; i++) {
			if (NbPremiersCalculatorUtils.OptimizedSquare.isNombrePremier(i)) {
				if (displayTrace) LOGGER.info("> Nombre 1er : {}", i);
				nbFound++;
				if (bar!=null) bar.setValue(new Integer(""+i));
			}
		}
		return nbFound;
	}

	public int chercheOptimEratostheneWithLongApproach(long nbDebut, long nbFin, boolean displayTrace, JProgressBar bar) {
		int nbFound = 0;

		if (bar != null) {
			try {
				Integer mxInt = new Integer(""+nbFin);
				bar.setMaximum(mxInt);
			} catch (Exception e) {
				LOGGER.error("Probleme lors de l'initialisation de la barre de progression", e);
				bar = null;
			}
		}
		
		Eratosthenes2 appli = new Eratosthenes2();
		appli.calculateFor(nbFin);
		for (long i = nbDebut; i < nbFin; i++) {
			if (appli.get(i)) { 
				if (displayTrace) LOGGER.info("> Nombre 1er : {}", i);
				nbFound++;
				if (bar!=null) bar.setValue(new Integer(""+i));
			}
		}

		return nbFound;
	}
	
	
	
}
