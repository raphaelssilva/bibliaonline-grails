package biz.r2s.bibliaonline;

import java.io.Serializable;
import java.util.List;


class Livro  implements Serializable{

	String nome;

	String sigla;
	
	int posicao

	Testamento testamento;
	
	static hasMany = [versiculos:Versiculo]
	
	static mappedBy = [versiculos:'livro']
	
	static mapping = {
		version false
		table 'livros'
		id column:'liv_id', type:'long', sqlType:'int'
		nome column:'liv_nome'
		posicao column:'liv_posicao'
		testamento column:'tes_id'
		sigla column:'liv_sigla', nullable:true		
		versiculos lazy:true
	}
}
