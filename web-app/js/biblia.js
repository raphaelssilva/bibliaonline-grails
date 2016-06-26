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

$(document).ready(function () {
	
	dataSource = new kendo.data.DataSource({
        transport: {
            read:  {
                url: "/admin/biblia/listAjax",
                dataType: "json"
            },
            update: {
                url: "/admin/biblia/saveAjax",
                dataType: "json",
                type:"POST"
            },
            destroy: {
                url: "/admin/biblia/deleteAjax",
                dataType: "json"
            },
            create: {
                url: "/admin/biblia/saveAjax",
                dataType: "json",
                type:"POST"
            },
            parameterMap: function(options, operation) {
            	debugger;
                if (operation == "update" && options.models) {
                	return {id: options.models[0].id, nome:options.models[0].nome, sigla:options.models[0].sigla, edicao:options.models[0].edicao, linguagem:options.models[0].linguagem};
                }else if (operation == "destroy" && options.models) {
                	return {id: options.models[0].id};
                }else if (operation == "create" && options.models) {
                	return {nome:options.models[0].nome, sigla:options.models[0].sigla, edicao:options.models[0].edicao, linguagem:options.models[0].linguagem};
                }
            }
        },
        batch: true,
        pageSize: 20,
        schema: {
            model: {
                id: "id",
                fields: {
                    id: { editable: false, nullable: true },
                    nome: { validation: { required: true } },
                    sigla: { validation: { min:3, max:3, required: true } },
                    edicao: { validation: { required: false } },
                    linguagem: { validation: { required: true } }
                }
            }
        }
    });
	
	
	$("#data-grid-usuario").kendoGrid({
		editable: "popup",
		dataSource : dataSource,
		pageable : true,
		columns : [ {
			field : "id",
			title:"Identificador"
		}, {
			field : "nome",
			title:"Nome"
		}, {
			field : "sigla",
			title:"Sigla"
		},  {
			field : "edicao",
			title:"Edição"
		}, {
			field : "linguagem",
			title:"Linguagem"
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
		toolbar : ["create"]
	});
});
/*
 * dataSource2.read();
 */