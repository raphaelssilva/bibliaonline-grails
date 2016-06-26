package biz.r2s.bibliaonline;

import java.io.Serializable;

public class Testamento {

	String nome;
	static hasMany = [livros:Livro]
	
	static mappedBy = [livros:'testamento']
	
	static mapping = {
		version false
		table 'testamento'
		id column:'tes_id', type:'long', sqlType:'int'
		nome column:'tes_nome'
		livros lazy:true
	}
}