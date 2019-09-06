//datatables - lista
$(document).ready(function() {
	moment.locale('pt-BR');
	var table = $('#table-turmas').DataTable({
		searching : false,
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
			url : '/turmas/datatables/server',
			data : 'data'
		},
		columns : [
				{data : 'id'},
				{data : 'serie.nome'},
				{data : 'descricao'},
				{data : 'ano'},
				{data : 'pel'},
				{	data : 'id',	
					render : function(id) {
						return ''.concat('<a class="btn btn-info btn-sm btn-block"', ' ')
								 .concat('href="').concat('/turmas/matriculados/').concat(id, '"', ' ') 
								 .concat('role="button" title="Visualizar" data-toggle="tooltip" data-placement="right">', ' ')
								 .concat('<i class="fas fa-edit"></i></a>');
					},
					orderable : false
				},
				{	data : 'id',	
					render : function(id) {
						return ''.concat('<a class="btn btn-success btn-sm btn-block"', ' ')
								 .concat('href="').concat('/turmas/editar/').concat(id, '"', ' ') 
								 .concat('role="button" title="Editar" data-toggle="tooltip" data-placement="right">', ' ')
								 .concat('<i class="fas fa-edit"></i></a>');
					},
					orderable : false
				},
				   {orderable: false,
		             data: 'id',
		                "render": function(id) {
		                    return '<a class="btn btn-danger btn-sm btn-block" href="/turmas/excluir/'+ 
		                    	id +'" role="button" data-toggle="modal" data-target="#confirm-modal"><i class="fas fa-times-circle"></i></a>';
		                }               
		            }
		]
	});
	
    $('#table-usuarios tbody').on('click', '[id*="dp_"]', function () {
    	var data = table.row($(this).parents('tr')).data();
    	var aux = new Array();
		$.each(data.perfis, function( index, value ) {
			  aux.push(value.id);
		});
		document.location.href = '/u/editar/dados/usuario/' + data.id + '/perfis/' + aux;
    } );
    

    
    
    
	$('#table-alunos').DataTable({
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
			url : '/alunos/datatables/server',
			data : 'data'
		},
		columns : [
				{data : 'id'},
				{data : 'nomeGuerra'},
				{data : 'alunoNome'},									 
				{	data : 'id',	
					render : function(id) {
						return ''.concat('<a class="btn btn-success btn-sm btn-block"', ' ')
								 .concat('href="').concat('/alunos/editar/').concat(id, '"', ' ') 
								 .concat('role="button" title="Editar" data-toggle="tooltip" data-placement="right">', ' ')
								 .concat('<i class="fas fa-edit"></i></a>');
					},
					orderable : false
				},
				   {orderable: false,
		             data: 'id',
		                "render": function(id) {
		                    return '<a class="btn btn-danger btn-sm btn-block" href="/alunos/excluir/'+ 
		                    	id +'" role="button" data-toggle="modal" data-target="#confirm-modal"><i class="fas fa-times-circle"></i></a>';
		                }               
		            }
		]
	});
});	