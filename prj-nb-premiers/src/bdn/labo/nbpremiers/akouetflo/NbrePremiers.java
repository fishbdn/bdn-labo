package bdn.labo.nbpremiers.akouetflo;
import java.util.Date;


public class NbrePremiers {

	
	public static void main(String[] args) {
		
		
		long seuilMin = 5000000000000000000L;
		long seuilMqx = 5000000000000009000L;
		

		Date startOptim = new Date();
				
		for (long i = seuilMin; i < seuilMqx; i++) {
			
//			if (isNombrePremierOptim(i)) {
//					System.out.println("===[" + new Date() + "]==== >> NOMBRE PREMIER OPTIM !!  => " + i);
//			}
			
		
			isNbPremierOptimTraceTime(i);
		}
			
		Date dureeOptim = new Date((new Date()).getTime() - startOptim.getTime());
		
		System.out.println("");
		System.err.println("###### FIN OPTIM " + dureeOptim.getTime() + " ms");
		
		System.gc();
		
		Date startNormal = new Date();
		for (long i = seuilMin; i < seuilMqx; i++) {
//			if (isNombrePremier(i)) {
//				System.out.println("===[" + new Date() + "]==== >> NOMBRE PREMIER !!  => " + i);
//			}
			
			isNbPremierTraceTime(i);
		}
		
		
		
		Date duree = new Date((new Date()).getTime() - startNormal.getTime());

		System.out.println("");
		
		System.err.println("###### FIN OPTIM " + dureeOptim.getTime() + " ms");
		
		System.err.println("###### FIN NORMAL " + duree.getTime() + " ms");
		
		System.err.println("###### GAIN OPTIM " + (duree.getTime() / dureeOptim.getTime() *100 )+ " %");
	}
	
		
	
	protected static boolean isNbPremierOptimTraceTime(long nb) {
		Date start = new Date();
		
		boolean isNbPr = isNombrePremierOptim(nb);
		
		Date duree = new Date((new Date()).getTime() - start.getTime());
		
		if (isNbPr) {
			System.out.println(nb+ " IS  NOMBRE PREMIER OPTIM / tps recherche ="+ duree.getTime() + " ms");
		}
		
		return isNbPr;
	}
	
	protected static boolean isNbPremierTraceTime(long nb) {
		Date start = new Date();
		
		boolean isNbPr = isNombrePremier(nb);
		
		Date duree = new Date((new Date()).getTime() - start.getTime());
		
		if (isNbPr) {
			System.out.println(nb+ " IS  NOMBRE PREMIER / tps recherche ="+ duree.getTime() + " ms");
		}
		return isNbPr;
	}
	
	protected static boolean isNombrePremierOptim (long nb) {
		if (nb == 2) {
			return true;
		}
		if (nb%2 == 0) {
			return false;
		}
		
		for (long d = 3; d < Math.sqrt(nb+1); d+=2) {
			if (nb % d == 0) {
				return false;
			}
		}

		return true;
	}
	
	protected static boolean isNombrePremier (long nb) {
		for (long d = 2; d < nb; d++) {
			if (nb % d == 0) {
//				System.out.println(nb + " pas nbre premier !! :(");
//				System.out.println("[!]""d/nb = " + nb % d);
				return false;
			}
		}
		
//		System.err.println("c=" + c);
		
//		System.out.println("[!!!]"+ nb + " est un nbre premier");
//		System.out.println("d/nb = " + nb);
//		
		return true;
	}
	
	protected static long cherchePremierCloserUp(long nb) {
		long maxMem = 1000000000L;
		try {
			for (long d = nb; d < maxMem; d++) {
				if (isNombrePremier(nb)) {
					return d;
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} 
			return -1;	
		
		
	}
	
	protected static long cherchePremierCloserDown(long nb) {
		try {
			for (long d = nb-1; d > 2; d--) {
				if (isNombrePremier(nb)) {
					return d;
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return -1;	
		
	}



	/**
	 * TODO : A finaliser
	 */
	protected static void draftChercherInferieurSuperieur() {
		long seuil = 100;
		
		for (long i = 0; i < seuil; i++) {
			
			if (!isNombrePremier(seuil)) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("1er superieur = " + cherchePremierCloserUp(i));
				System.out.println("1er inferieur = " + cherchePremierCloserDown(i));
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			} 
				

			System.out.println("================================================");
			System.out.println(" >> NOMBRE PREMIER !! > " + i);
			System.out.println("================================================");
		}
		
	}













}













