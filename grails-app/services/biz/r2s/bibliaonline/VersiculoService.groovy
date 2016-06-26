package biz.r2s.bibliaonline

class VersiculoService {

	def getVersiculo(String biblia, String livro, int capitulo, int versiculo){
		Versiculo.executeQuery("""
			select
				v
			from
				Versiculo v inner join
				v.livro l inner join
				v.biblia b
			where
				b.sigla = '${biblia}' and
				l.sigla = '${livro}' and
				v.capitulo = ${capitulo} and 
				v.numero = ${versiculo}
		""")?.first()
	}
	
    def listByCapitulo(String biblia, String livro, int capitulo){
		Versiculo.executeQuery("""
			select
				v
			from
				Versiculo v inner join
				v.livro l inner join
				v.biblia b
			where
				b.sigla = '${biblia}' and
				l.sigla = '${livro}' and
				v.capitulo = ${capitulo}
			order by v.numero
		""")
	}
	
	def listByLivro(String biblia, String livro){
		Versiculo.executeQuery("""
			select
				v
			from
				Versiculo v inner join
				v.livro l inner join
				v.biblia b
			where
				b.sigla = '${biblia}' and
				l.sigla = '${livro}'
			order by v.capitulo, v.numero
		""")
	}
	
	def listByBiblia(String biblia){
		Versiculo.executeQuery("""
			select
				v
			from
				Versiculo v inner join
				v.livro l inner join
				v.biblia b
			where
				b.sigla = '${biblia}'
			order by l.testamento, l.posicao, v.capitulo, v.numero
		""")
	}
	
	
	def listNumeroCapitulosByLivro(String biblia, String livro){
		Versiculo.executeQuery("""
			select  distinct
				v.capitulo
			from
				Versiculo v inner join
				v.livro l inner join
				v.biblia b
			where
				b.sigla = '${biblia}' and
				l.sigla = '${livro}'
			order by v.capitulo
		""")
	}
	
	def listNumeroVersiculosByCapitulo(String biblia, String livro, int capitulo){
		Versiculo.executeQuery("""
			select distinct
				v.numero
			from
				Versiculo v inner join
				v.livro l inner join
				v.biblia b
			where
				b.sigla = '${biblia}' and
				l.sigla = '${livro}' and
				v.capitulo = ${capitulo}
			order by v.numero
		""")
	}
}
