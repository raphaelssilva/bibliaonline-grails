package biz.r2s.bibliaonline;

import java.io.Serializable;
import java.util.List;

import biz.r2s.bibliaonline.Livro;

class Biblia implements Serializable {

	String nome;
	String sigla;
	String edicao;
	String linguagem;
	
	static mapping = {
		version false
		table 'versoes'
		id column:'vrs_id', type:'long', sqlType:'int'
		nome column:'vrs_nome'
		sigla column:'vrs_sigla', nullable:true
		edicao column:'vrs_edicao', nullable:true
		linguagem column:'vrs_linguagem', nullable:true
		versiculos lazy:true
	}
	
	static hasMany = [versiculos:Versiculo]
	
	static mappedBy = [versiculos:'biblia']
}
