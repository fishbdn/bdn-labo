package bdn.labo.nbpremiers.eratosthenes;

import java.util.BitSet;

/**
 * Calcul astucieux suivant l'algo du crible Eratosthenes
 * 
 * L'algorithme procède par élimination : 
 * il s'agit de supprimer d'une table des entiers de 2 à N tous les multiples d'un entier. 
 * En supprimant tous les multiples, à la fin il ne restera que les entiers qui ne sont multiples d'aucun entier, 
 * et qui sont donc les nombres premiers.
 * 
 * > http://fr.wikipedia.org/wiki/Crible_d%27%C3%89ratosth%C3%A8ne
 * 
 * L’astuce consiste bien entendu à stocker le crible sous la forme d’un tableau de bits représentant tous les nombres. 
 * Cette solution amusante est extrêmement économique, rapide et simple. 
 * Ainsi pour savoir si le nombre 953 est premier, on vérifie la 953ème position dans le champ de bits 
 * (100 octets permettent de stocker le criblage pour les nombres de 1 à 800).
 * 
 * > http://wrey75.wordpress.com/2010/02/09/calcul-de-nombres-premiers/
 * 
 * (Cette technique donne d’assez bon résultats.)
 * 
 * @author bdn
 *
 */
public class Eratosthenes {
	BitSet a = null;

	public BitSet calculateFor(int n) {
		BitSet a = new BitSet(n);
		a.clear(1);
		for (int i = 2; i < n; i++) {
			a.set(i);
		}
		int p = 2;
		while ((p * p) < n) {
			int j = p * p;
			while (j <= n) {
				a.clear(j);
				j = j + p;
			}

			do {
				p++;
			} while (!a.get(p));
		}
		return (a);
	}

	public static void main(String[] args) {
		int n = 300000000;
		Eratosthenes appli = new Eratosthenes();
		
		System.out.println("> Debut du calcul pour " + n);
		BitSet a = appli.calculateFor(n);
		
		
		for (int i = 2; 1 < n; i++) {
			if (a.get(i)) {
				System.out.println(i);
			}
		}
	}
}