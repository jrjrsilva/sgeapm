$(document).ready(function () {
	moment.locale('pt-BR');
    var table = $('#table-serie').DataTable({
    	searching: true,
    	order: [[ 1, "asc" ]],
    	lengthMenu: [10],
        processing: true,
        serverSide: true,
        responsive: true,
        "language": {
            "lengthMenu": "Mostrando _MENU_ registros por página",
            "zeroRecords": "Nothing found - sorry",
            "info": "Página _PAGE_ de _PAGES_",
            "infoEmpty": "Não foram encotrados registros",
            "search": "Filtro",
            
            paginate: {
	            first:      "Primeiro",
	            previous:   "Anterior",
	            next:       "Próximo",
	            last:       "Último"
	        },
        }
	,
	 
        
        ajax: {
            url: '/series/datatables/server',
            data: 'data'
        },
        columns: [
            {data: 'id'},
            {data: 'nome'},
            {data: 'apelido'},
            {data: 'ano'},
            {orderable: false, 
             data: 'id',
                "render": function(id) {
                    return '<a class="btn btn-success btn-sm btn-block" href="/series/editar/'+ 
                    	id +'" role="button"><i class="fas fa-edit"></i></a>';
                }
            },
            {orderable: false,
             data: 'id',
                "render": function(id) {
                    return '<a class="btn btn-danger btn-sm btn-block" href="/series/excluir/'+ 
                    	id +'" role="button" data-toggle="modal" data-target="#confirm-modal"><i class="fas fa-times-circle"></i></a>';
                }               
            }
        ]
    });
});    
