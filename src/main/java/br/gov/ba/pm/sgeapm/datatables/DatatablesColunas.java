package br.gov.ba.pm.sgeapm.datatables;

public class DatatablesColunas {

	public static final String[] ESPECIALIDADES = {"id", "titulo"};

	public static final String[] MEDICOS = {"id", "nome", "crm", "dtInscricao", "especialidades"};
	
	public static final String[] AGENDAMENTOS = {"id", "paciente.nome", "dataConsulta", "medico.nome", "especialidade.titulo"};

	public static final String[] USUARIOS = {"id", "email", "ativo", "perfis"};
	
	public static final String[] ALUNOS = {"id", "matricula", "alunoNome"};

	public static final String[] SERIES = {"id", "nome", "ano","apelido"};

	public static final String[] TURMAS = {"id", "letra", "pel", "ano"};

	public static final String[] MATRICULADOS = {"id", "numero", "aluno.alunoNome","aluno.nomeGuerra","ano","turma.ano"};
}
