package br.gov.ba.pm.sgeapm.domain;

public enum Pelotao {
	ALFA(1, "1º PEL"), BRAVO(2, "2º PEL"), CHARLE(3, "3º PEL"), DELTA(4, "4º PEL"), ECHO(5, "5º PEL"), FOX(6, "6º PEL");
	
	private long cod;
	private String desc;

	private Pelotao(long cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public long getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}
