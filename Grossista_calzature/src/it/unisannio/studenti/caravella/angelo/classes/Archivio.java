package it.unisannio.studenti.caravella.angelo.classes;

import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.ArticoliCallback;
import it.unisannio.studenti.caravella.angelo.utils.MagazzinoCallback;
import it.unisannio.studenti.caravella.angelo.utils.MagazzinoCallbackLuogo;
import it.unisannio.studenti.caravella.angelo.utils.MagazzinoNotFoundException;
import it.unisannio.studenti.caravella.angelo.utils.ProdottoNotFoundException;

public class Archivio {

	public Archivio(Scanner sc1, Scanner sc2, Scanner sc3) {

		this.prodotti = new HashMap<String, Prodotto>();

		Prodotto p = Prodotto.read(sc1);

		while (p != null) {

			this.prodotti.put(p.getCodice_prodotto(), p);
			p = Prodotto.read(sc1);
		}

		this.magazzino = new HashMap<String, Magazzino>();
		Magazzino m = Magazzino.read(sc2);

		while (m != null) {

			this.magazzino.put(m.getId_magazzino(), m);
			m = Magazzino.read(sc2);
		}

		this.stoccaggio = new HashSet<Stoccaggio>();
		Stoccaggio s = Stoccaggio.read(sc3);

		while (s != null) {
			CollegamentoProdottoMagazzino(s.getCodice_prodotto(), s.getCodice_magazzino());

			this.stoccaggio.add(s);
			s = Stoccaggio.read(sc3);
		}

	}

	private void CollegamentoProdottoMagazzino(String codiceprodotto, String codicemagazzino) {

		Prodotto p = this.prodotti.get(codiceprodotto);
		Magazzino m = this.magazzino.get(codicemagazzino);

		if (p == null)
			throw new ProdottoNotFoundException("Non esiste il prodotto specificato");
		if (m == null)
			throw new MagazzinoNotFoundException("Non esiste il magazzino specificato");

		if (p != null && m != null) {

			m.addProdotto(p);
			p.setMagazzino(m);
		}

	}

	public HashMap<String, Magazzino> FiltraProdottiMagazzino(String codice_magazzino) {

		MagazzinoCallback magazzino = new MagazzinoCallback(codice_magazzino);

		Map<String, Magazzino> magazzinoFiltro = new HashMap<String, Magazzino>();

		Set<String> chiavi = this.magazzino.keySet();
		for (String s : chiavi) {

			if (magazzino.Verify(this.magazzino.get(s))) {

				magazzinoFiltro.put(s, this.magazzino.get(s));
			}

		}
		return (HashMap<String, Magazzino>) magazzinoFiltro;
	}

	public HashMap<String, Prodotto> ArticoliDellaMarca(String marca) {
		ArticoliCallback articoli = new ArticoliCallback(marca);
		Map<String, Prodotto> prodottoFiltro = new HashMap<String, Prodotto>();

		Set<String> chiavi = this.prodotti.keySet();
		for (String s : chiavi) {

			if (articoli.Verify(this.prodotti.get(s))) {

				prodottoFiltro.put(s, this.prodotti.get(s));

			}

		}
		return (HashMap<String, Prodotto>) prodottoFiltro;
	}

	public void StampaArchivio(HashMap<String, Magazzino> magazzinofiltrato) {
		magazzinofiltrato.entrySet().forEach(entry -> {

			entry.getValue().PrintProdotti();
		});

	}

	public HashMap<String, Magazzino> FiltraMagazzinoDelLuogo(String luogo) {
		MagazzinoCallbackLuogo magazzino = new MagazzinoCallbackLuogo(luogo);

		Map<String, Magazzino> magazzinoFiltro = new HashMap<String, Magazzino>();

		Set<String> chiavi = this.magazzino.keySet();
		for (String s : chiavi) {

			if (magazzino.Verify(this.magazzino.get(s))) {

				magazzinoFiltro.put(s, this.magazzino.get(s));
			}

		}
		return (HashMap<String, Magazzino>) magazzinoFiltro;

	}

	public void StampaProdotto(HashMap<String, Prodotto> prodotto) {
		prodotto.entrySet().forEach(entry -> {

			System.out.println(entry.getKey() + " " + entry.getValue());
		});

	}

	public void StampaMagazzino(HashMap<String, Magazzino> magazzino2) {
		magazzino2.entrySet().forEach(entry -> {

			System.out.println(entry.getKey() + " " + entry.getValue());
		});

	}

	public void StampaProdottoLocalizzato(HashMap<String, Magazzino> magazzino2) {
		magazzino2.entrySet().forEach(entry -> {

			entry.getValue().PrintProdotti();
		});

	}

	public String FiltraProdottoQuantità(int quantità) {
		for (Stoccaggio s : this.stoccaggio) {

			if (s.getQuantità() == quantità)
				return s.getCodice_magazzino();
		}
		return null;
	}

	public String TrovaProdotto(HashMap<String, Magazzino> magazzino3, String tipo, String colore, String marca) {

		Set<String> chiavi = magazzino3.keySet();
		String id = null;
		for (String s : chiavi) {

			Magazzino m = magazzino3.get(s);

			LinkedList<Prodotto> pr = m.getProdotti();
			id = CercaProdotto(pr, tipo, colore, marca);

		}
		return id;
	}

	private String CercaProdotto(LinkedList<Prodotto> pr, String tipo, String colore, String marca) {

		for (Prodotto p : pr) {

			if (p.getColore().equals(colore) && p.getDescrizione().equals(tipo) && p.getMarca().equals(marca))
				return p.getMagazzino().getId_magazzino();

		}
		return null;

	}

	public void PrintMagazzino(String idmag) {
		Magazzino m = this.magazzino.get(idmag);
		if (m == null)
			throw new MagazzinoNotFoundException("Non esiste il magazzino specificato");

			System.out.println(m.toString());
	}

	private Set<Stoccaggio> stoccaggio;

	private Map<String, Prodotto> prodotti;
	private Map<String, Magazzino> magazzino;

}
