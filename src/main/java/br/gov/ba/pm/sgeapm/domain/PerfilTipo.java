package br.gov.ba.pm.sgeapm.domain;

public enum PerfilTipo {
	ADMIN(1, "ADMIN"), INSTRUTOR(2, "INSTRUTOR"), ALUNO(3, "ALUNO"), USUARIO(3, "USUARIO");
	
	private long cod;
	private String desc;

	private PerfilTipo(long cod, String desc) {
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
