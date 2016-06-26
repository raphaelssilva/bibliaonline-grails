package biz.r2s.bibliaonline;

import java.io.Serializable;


public class Versiculo  implements Serializable{

	int numero, capitulo;
	String texto;
	
	static belongsTo = [biblia:Biblia, livro:Livro]

	static mapping = {
		version false
		table 'versiculos'
		id column:'ver_id', type:'long', sqlType:'int'
		numero column:'ver_versiculo'
		capitulo column:'ver_capitulo'
		texto column:'ver_texto', sqlType:'text'
		biblia column:'ver_vrs_id', type:'long', sqlType:'int'
		livro column:'ver_liv_id', type:'long', sqlType:'int'
	}
	
}
