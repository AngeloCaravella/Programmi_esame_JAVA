package it.unisannio.studenti.caravella.angelo.classes;

import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.ProvinceNotFoundException;
import it.unisannio.studenti.caravella.angelo.utils.RegioneNotFoundException;

public class Contabilità {

	public Contabilità(int somma_m, int somma_f, int somma_t, int temp_max) {
		this.somma_m = somma_m;
		this.somma_f = somma_f;
		this.somma_t = somma_t;
		this.temp_max = temp_max;
	}

	public Contabilità(Scanner sc1, Scanner sc2) {

		Provincia pr = Provincia.read(sc1);
		this.province = new HashMap<String, Provincia>();
		while (pr != null) {
			province.put(pr.getNome_provincia(), pr);
			pr = Provincia.read(sc1);
		}
		Regione re = Regione.read(sc2);
		this.regioni = new HashMap<String, Regione>();
		while (re != null) {
			regioni.put(re.getNome(), re);
			CollegamentoRegione_Province(re.getNomi_province(), re);
			re = Regione.read(sc2);
		}
	}

	/**
	 * @param province
	 * @param regioni
	 */
	public Contabilità(HashMap<String, Provincia> province, HashMap<String, Regione> regioni) {
		this.province = province;
		this.regioni = regioni;
	}

	public void CollegamentoRegione_Province(LinkedList<String> nomi_p, Regione r) {

		for (String s : nomi_p) {
			Controllo(s, r);
		}

	}

	public void Controllo(String nome, Regione r) {
		try {
			Provincia pr = SearchP(nome);
			pr.setRegione_di_provenienza(r);
		}

		catch (ProvinceNotFoundException pr) {
			System.err.println(pr.getMessage());
		}
	}

	public Provincia SearchP(String nome_p) {

		Provincia pr = this.province.get(nome_p);
		if (pr == null)
			throw new ProvinceNotFoundException("La provincia con il nome: " + nome_p + " non è stata trovata");
		return pr;

	}

	public Contabilità ContNum(String nome_p) {
		Provincia pr = this.province.get(nome_p);
		if (pr == null)
			throw new ProvinceNotFoundException("La provincia con il nome: " + nome_p + " non è stata trovata");

		LinkedList<Comune> com = pr.getInfo_comune();

		return this.ContNumComune(com);
	}

	private Contabilità ContNumComune(LinkedList<Comune> com) {
		// VARIABILI PER LA SOMMA TOTALE
		int somma_m = 0;
		int somma_f = 0;
		int somma_t = 0;

		// VARIABILI PER LA SOMMA PARZIALE UTILIZZATE PER CERCARE IL COMUNE PIU' GRANDE
		int t_somma = 0;
		int t_m = 0;
		int t_f = 0;
		int temp_max = 0;

		for (Comune c : com) {
			t_m = t_m + c.getNumero_maschi();
			t_f = t_f + c.getNumero_femmine();

			somma_f = somma_f + c.getNumero_femmine();
			somma_m = somma_m + c.getNumero_maschi();
			somma_t = somma_f + somma_m;

			t_somma = t_m + t_f;

			t_m = 0;
			t_f = 0;

			if (t_somma > temp_max)
				temp_max = t_somma;
			t_somma = 0;
		}
		this.temp_max = temp_max;
		return new Contabilità(somma_m, somma_f, somma_t, temp_max);

	}

	public Contabilità FindBigger(String nome_p) {
		Provincia pr = this.province.get(nome_p);
		if (pr == null)
			throw new ProvinceNotFoundException("La provincia con il nome: " + nome_p + " non è stata trovata");

		LinkedList<Comune> com = pr.getInfo_comune();
		return this.FindBiggerInto(com);
	}

	public Contabilità FindBiggerCountry(String nome_regione) {
		Regione re = this.regioni.get(nome_regione);
		if (re == null)
			throw new RegioneNotFoundException("La regione con il nome: " + nome_regione + " non è stata trovata");
		LinkedList<String> province = re.getNomi_province();
		return this.FindBiggerIntoCountry(province, nome_regione);
	}

	private Contabilità FindBiggerIntoCountry(LinkedList<String> province, String nome_regione) {
		int somma_f = 0;
		for (String s : province) {
			Provincia p = this.province.get(s);
			LinkedList<Comune> com = p.getInfo_comune();
			somma_f = FindBiggerIntoAllProvinces(com);
			p.setNumero_cit_prov(somma_f);
			p.setNumero_cit_f(this.somma_f);
			p.setNumero_cit_m(this.somma_m);
		}
		return this.FinalSumOfProvinces(nome_regione);
	}

	private int FindBiggerIntoAllProvinces(LinkedList<Comune> com) {
		int somma_m = 0;
		int somma_f = 0;
		int somma_t = 0;

		for (Comune c : com) {

			somma_f = somma_f + c.getNumero_femmine();
			somma_m = somma_m + c.getNumero_maschi();
			somma_t = somma_f + somma_m;
		
		}
		this.somma_f=somma_f;
		this.somma_m=somma_m;
		return somma_t;
	}

	private Contabilità FinalSumOfProvinces(String nome_regione) {
		Regione re = this.regioni.get(nome_regione);
		LinkedList<String> province = re.getNomi_province();
		int somma = 0;
		int sommam = 0;
		int sommaf = 0;
		for (String p : province) {

			Provincia pr = this.province.get(p);
			somma = somma + pr.getNumero_cit_prov();
			sommaf= sommaf+ pr.getNumero_cit_f();
			sommam= sommam+ pr.getNumero_cit_m();
		}
		return this.PrintResult(somma,sommam, sommaf ,nome_regione);
	}

	private Contabilità PrintResult(int somma,int sommam,int sommaf, String nome_regione) {

		System.out.println(
				"Per la regione: " + nome_regione + " la somma degli abitanti di tutte le province è: " + somma+ " di cui: "+ sommam +" maschi e : "+ sommaf + " femmine");

		return null;
	}

	private Contabilità FindBiggerInto(LinkedList<Comune> com) {
		int somma_m = 0;
		int somma_f = 0;
		int somma_t = 0;

		for (Comune c : com) {

			somma_f = somma_f + c.getNumero_femmine();
			somma_m = somma_m + c.getNumero_maschi();
			somma_t = somma_f + somma_m;

			if (somma_t == this.temp_max)
				PrintComune(c);
		}
		return null;
	}

	private void PrintComune(Comune c) {
		System.out.println(c.toString());
	}

	public void PrintInfoProvincia() {

		System.out.println("Il numero di cittadini totali nella provincia è:  " + this.somma_t
				+ " il numero di maschi: " + this.somma_m + " il numero di femmine: " + this.somma_f);
	}

	public void PrintAll() {

		this.province.entrySet().forEach(entry -> {

			System.out.println(entry.getKey() + entry.getValue());
		});

		System.out.println(" Regioni:");
		this.regioni.entrySet().forEach(entry -> {

			System.out.println(entry.getKey() + entry.getValue());
		});

	}

	private HashMap<String, Provincia> province;
	private HashMap<String, Regione> regioni;
	private int somma_m;
	private int somma_f;
	private int somma_t;
	private int temp_max;

}
