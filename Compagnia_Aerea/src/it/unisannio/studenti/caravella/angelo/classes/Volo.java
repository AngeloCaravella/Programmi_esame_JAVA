package it.unisannio.studenti.caravella.angelo.classes;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.*;

import it.unisannio.studenti.caravella.angelo.utils.Constants;

public class Volo {

	/**
	 * @param identificativo
	 * @param citta_p
	 * @param citta_a
	 * @param data_p
	 * @param numero_massimo_posti
	 * @param codice_fisc_clienti
	 */
	public Volo(String identificativo, String citta_p, String citta_a, Date data_p, int numero_massimo_posti,
			LinkedList<String> codice_fisc_clienti) {
		this.identificativo = identificativo;
		this.citta_p = citta_p;
		this.citta_a = citta_a;
		this.data_p = data_p;
		this.numero_massimo_posti = numero_massimo_posti;
		this.codice_fisc_clienti = codice_fisc_clienti;
		this.clienti=new LinkedList<Cliente>();
	}

	public static Volo read(Scanner sc) {
		if (!sc.hasNextLine())
			return null;
		String id = sc.nextLine();

		if (!sc.hasNextLine())
			return null;
		String cit_p = sc.nextLine();

		if (!sc.hasNextLine())
			return null;
		String cit_a = sc.nextLine();

		if (!sc.hasNextLine())
			return null;
		String d = sc.nextLine();

		Date data = null;
		try {
			data = Constants.ddMMyyyy.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (!sc.hasNextLine())
			return null;
		String num = sc.nextLine();

		int num_m_p = Integer.parseInt(num);

		LinkedList<String> clienti = new LinkedList<String>();

		String cli = null;

		cli = sc.nextLine();

		while (!cli.equals("#")) {
			clienti.add(cli);
			cli = sc.nextLine();
		}

		return new Volo(id, cit_p, cit_a, data, num_m_p, clienti);
	}

	@Override
	public String toString() {
		return "Volo [identificativo=" + identificativo + ", citta_p=" + citta_p + ", citta_a=" + citta_a + ", data_p="
				+ data_p + ", numero_massimo_posti=" + numero_massimo_posti + ", codice_fisc_clienti="
				+ codice_fisc_clienti + "]";
	}

	public static Volo read() throws ParseException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Inserisci l'id del volo: ");
		String id = sc.nextLine();
		if (id.equals(""))
			return null;

		System.out.println("Inserisci la città di partenza: ");
		String cit_p = sc.nextLine();
		if (cit_p.equals(""))
			return null;

		System.out.println("Inserisci la città di arrivo: ");
		String cit_a = sc.nextLine();
		if (cit_a.equals(""))
			return null;

		System.out.println("Inserisci la data: ");
		String d = sc.nextLine();
		if (d.equals(""))
			return null;

		Date data = null;
		try {
			data = Constants.ddMMyyyy.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Inserisci la data: ");
			d = sc.nextLine();
			data = Constants.ddMMyyyy.parse(d);
		}

		System.out.println("Inserisci il numero massimo di posti: ");
		String num = sc.nextLine();
		if (num.equals(""))
			return null;

		int num_m_p = Integer.parseInt(num);

		LinkedList<String> clienti = new LinkedList<String>();

		String cli = null;
		System.out.println("Inserisci il cliente: ");
		cli = sc.nextLine();
		if (cli.equals(""))
			return null;

		clienti.add(cli);

		return new Volo(id, cit_p, cit_a, data, num_m_p, clienti);
	}

	/**
	 * @param numero_massimo_posti the numero_massimo_posti to set
	 */
	public void setNumero_massimo_posti(int numero_massimo_posti) {
		this.numero_massimo_posti = numero_massimo_posti - 1;
	}

	/**
	 * @return the identificativo
	 */
	public String getIdentificativo() {
		return identificativo;
	}

	/**
	 * @return the citta_p
	 */
	public String getCitta_p() {
		return citta_p;
	}

	/**
	 * @return the citta_a
	 */
	public String getCitta_a() {
		return citta_a;
	}

	/**
	 * @return the data_p
	 */
	public Date getData_p() {
		return data_p;
	}

	/**
	 * @return the numero_massimo_posti
	 */
	public int getNumero_massimo_posti() {
		return numero_massimo_posti;
	}

	/**
	 * @return the codice_fisc_clienti
	 */
	public LinkedList<String> getCodice_fisc_clienti() {
		return codice_fisc_clienti;
	}

	
	

	/**
	 * @return the clienti
	 */
	public LinkedList<Cliente> getClienti() {
		return clienti;
	}
	public void addCliente(Cliente c) {
		this.clienti.add(c);
	}

	public void print(PrintStream ps2) {
		ps2.println(this.identificativo);
		ps2.println(this.citta_p);
		ps2.println(this.citta_a);
		ps2.println(Constants.ddMMyyyy.format(this.data_p));
		ps2.println(this.numero_massimo_posti);
		printList(ps2);
		ps2.println("#");
	}

	public void printList(PrintStream ps2) {
		for (String v : this.codice_fisc_clienti) {
			ps2.println(v);

		}
	}

	private String identificativo;
	private String citta_p;
	private String citta_a;
	private Date data_p;
	private int numero_massimo_posti;
	private LinkedList<String> codice_fisc_clienti;
	private LinkedList <Cliente> clienti;

}