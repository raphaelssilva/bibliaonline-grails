package biz.r2s.bibliaonline

class LivroService {

    def getLivro(String biblia, String livro){
		Livro.executeQuery("""
			select  distinct l
			from
				Livro l inner join
				l.versiculos v inner join
				v.biblia b
			where
				b.sigla = '${biblia}' and
				l.sigla = '${livro}'
		""")?.first()
	}
	
	def listByBiblia(String biblia){
		Livro.executeQuery("""
			select distinct l
			from
				Livro l inner join
				l.versiculos v inner join
				v.biblia b
			where
				b.sigla = '${biblia}'
			order by l.testamento desc, l.posicao
		""")
	}
}
