//datatables - 
$(document).ready(function() {
	moment.locale('pt-BR');
	var 
	var table = $('#table-matriculados').DataTable({
		searching : true,
		lengthMenu : [30],
		processing : true,
		serverSide : true,
		responsive : true,
		
		 "language": {
	            "lengthMenu": "Mostrando _MENU_ registros por página",
	            "zeroRecords": "Nothing found - sorry",
	            "info": "Página _PAGE_ de _PAGES_",
	            "infoEmpty": "Não foram encotrados registros",
	            "infoFiltered": "(filtered from _MAX_ total records)",
	            "search": "Filtro",
	            
	            paginate: {
		            first:      "Primeiro",
		            previous:   "Anterior",
		            next:       "Próximo",
		            last:       "Último"
		        },
	        }
		,
		 
		
		ajax : {
			url : '/matriculados/datatables/server',
			data : 'data'
		},
		columns : [
				
				{data : 'aluno.nomeGuerra'},
				{data : 'aluno.alunoNome'},
				{data : 'numero'},
				{data : 'ano'},
				{data : 'turma.ano'},
				{	data : 'aluno.id',	
					render : function(id) {
						return ''.concat('<a class="btn btn-success btn-sm btn-block"', ' ')
								 .concat('href="').concat('/alunos/editar/').concat(id, '"', ' ') 
								 .concat('role="button" title="Editar" data-toggle="tooltip" data-placement="right">', ' ')
								 .concat('<i class="fas fa-edit"></i></a>');
					},
					orderable : false
				},
				   {orderable: false,
		             data: 'aluno.id',
		                "render": function(id) {
		                    return '<a class="btn btn-danger btn-sm btn-block" href="/alunos/excluir/'+ 
		                    	id +'" role="button" data-toggle="modal" data-target="#confirm-modal"><i class="fas fa-times-circle"></i></a>';
		                }               
		            }
		]
	});
	
});	

