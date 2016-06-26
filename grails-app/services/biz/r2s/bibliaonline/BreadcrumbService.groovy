package biz.r2s.bibliaonline

class BreadcrumbService {

	def bibliaService
	def livroService
	def versiculoService
	
    def biblia = { biblia ->
		def biblias = bibliaService.listAll()		
		
		[biblias:biblias.collect([title:it.nome, href:"/${it.sigla}"])]
	}
	
	def livro = { biblia, livro ->
		def biblias = bibliaService.listAll()		
		def livros = livroService.listByBiblia(biblia)
		
		[
			biblias:biblias.collect([title:it.nome, href:"/${it.sigla}"]), 
			livros:livros.collect([title:it.nome, href:"/${biblia}/${it.sigla}"]) 
		]
	}
	
	def capitulo = { biblia, livro, capitulo ->
		def biblias = bibliaService.listAll()		
		def livros = livroService.listByBiblia(biblia)
		def capitulos = versiculoService.listNumeroCapitulosByLivro(biblia, livro)
		
		[
			biblias:biblias.collect([title:it.nome, href:"/${it.sigla}"]), 
			livros:livros.collect([title:it.nome, href:"/${biblia}/${it.sigla}"]), 
			capitulos:capitulos.collect([title:it, href:"/${biblia}/${livro}/${it}"])
		]
	}
	
	def versiculo = { biblia, livro, capitulo, versiculo ->
		def biblias = bibliaService.listAll()		
		def livros = livroService.listByBiblia(biblia)
		def capitulos = versiculoService.listNumeroCapitulosByLivro(biblia, livro)
		def versiculos = versiculoService.listNumeroVersiculosByCapitulo(biblia, livro, capitulo)
		
		[
			biblias:biblias.collect([title:it.nome, href:"/${it.sigla}"]), 
			livros:livros.collect([title:it.nome, href:"/${biblia}/${it.sigla}"]), 
			capitulos:capitulos.collect([title:it, href:"/${biblia}/${livro}/${it}"]),
			versiculos:versiculos.collect([title:it, href:"/${biblia}/${livro}/${capitulo}/${it}"])
		]
	}
}
