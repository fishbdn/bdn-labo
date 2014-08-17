package bdn.labo.nbpremiers.deco.progressbar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bdn.nbpremiers.NbsPremiersLauncher;
import bdn.nbpremiers.service.impl.NbPremiersService;
import bdn.nbpremiers.util.NbPremiersCalculatorUtils;
import bdn.nbpremiers.util.NbPremiersCalculatorUtils.Eratosthenes2;

/**
 * Dojo pour afficher un barre de progression avec nombre premiers
 * 
 * @author bdn
 *
 */
public class ProgressNbPremiers extends JFrame {

	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(NbsPremiersLauncher.class);
	
	private Thread t;
	private JProgressBar bar;
	private JButton launch;

	public ProgressNbPremiers() {
		this.setSize(400, 50);
		this.setTitle("*** Recherche des nombre premiers ***");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		t = new Thread(new Traitement());
		bar = new JProgressBar();
		bar.setMaximum(100);
		bar.setMinimum(0);
		bar.setStringPainted(true);

		this.getContentPane().add(bar, BorderLayout.CENTER);

		launch = new JButton("Lancer");
		launch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				t = new Thread(new Traitement());
				t.start();
			}
		});
		this.getContentPane().add(launch, BorderLayout.SOUTH);
		t.start();
		this.setVisible(true);
	}
	
	
	class Traitement implements Runnable {
		public void run() {
			launch.setEnabled(false);

			int nbStart = 1;
			int nbMax = 900000000;
			
			bar.setMaximum(nbMax-(nbMax/15));
			
			NbPremiersService service = NbPremiersService.getInstance();
			int nbFound = service.chercheOptimEratostheneWithLongApproach(nbStart, nbMax, false, bar);
			
//			int nbFound = service.chercheOptimSquareApproach(nbStart, nbMax, false, bar);
			
//			int nbFound = service.chercheClassicalApproach(nbStart, nbMax, false, bar);
			
			LOGGER.info("> Nombre 1er trouves: {}", nbFound);
						
			launch.setEnabled(true);
		}
	}

	class TraitementOptim implements Runnable {
		public void run() {
			launch.setEnabled(false);

			int nbFound = 0;
			int nbStart = 100000;
			int nbMax = 100000000;
			
			bar.setMaximum(nbMax-10);
			
			Eratosthenes2 appli = new Eratosthenes2();
			appli.calculateFor(nbMax);
			for (int i = nbStart; i < nbMax; i++) {
				if (appli.get(i)) {
//					LOGGER.info("> Nombre 1er : {}", i);
					nbFound++;
				}
				
				bar.setValue(i);
			}
			LOGGER.info("> Nombre 1er trouves: {}", nbFound);
						
			launch.setEnabled(true);
		}
	}
	
	class TraitementClassic implements Runnable {
		public void run() {
			launch.setEnabled(false);

			int nbFound = 0;
			
			int nbStart = 1000;
			int nbMax = 100000;
			
			bar.setMaximum(nbMax-10);
			for (int i = nbStart; i <= nbMax; i++) {
				if (NbPremiersCalculatorUtils.Classical.isNombrePremier(i)) {
					LOGGER.info("> Nombre 1er : {}", i);
					
					bar.setValue(i);
					nbFound++;
				}
			}
			
			LOGGER.info("{} premiers trouvés !!", nbFound);
						
			launch.setEnabled(true);
		}
	}
	

	public static void main(String[] args) {
		new ProgressNbPremiers();
	}
}