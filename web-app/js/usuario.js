/*var dataSource2 = new kendo.data.DataSource({
  transport: {
    read: {
      url: "http://localhost:8888/admin/user/listUsuarioAjax",
      dataType: "jsonp"
    }
  },
  pageSize: 10
});*/

function editUsuario(){
	
}

$.post("/admin/user/listUsuarioAjax", function(dados) {
	$("#data-grid-usuario").kendoGrid({
		editable: "popup",
		dataSource : {
			data : dados,
			schema : {
				model : {
					id : "id"
				}
			},
			 destroy: {
                 url: "admin/user/deleteUsuarioAjax",
                 dataType: "jsonp"
             },
		},
		pageable : true,
		autoBind : true,
		columns : [ {
			field : "id",
			title:"Identificador"
		}, {
			field : "nome",
			title:"Nome"
		}, {
			field : "email",
			title:"E-mail"
		}, {
			command : [ {
				name : "edit",
				text : "Editar",
				title : "&nbsp;",
				width : 90
			}, {
				name : "destroy",
				text : "Deletar",
				title : "&nbsp;",
				width : 90
			}]}
		 ],
		toolbar : [ {
			template:'<a class="k-button k-button-icontext k-grid-add" href="/admin/user/new"><span class="k-icon k-add"></span>Novo Usuario</a>'
		} ]
	});
});
/*
 * dataSource2.read();
 */