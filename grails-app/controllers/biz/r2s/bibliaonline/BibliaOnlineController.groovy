package biz.r2s.bibliaonline

import javax.servlet.http.HttpServletResponse;

import grails.converters.JSON

class BibliaOnlineController {

	def bibliaService
	def livroService
	def versiculoService

	def index = {
		def livros = livroService.listByBiblia('nad')
		def biblias = bibliaService.listAll()
		def obj = [livros:livros, biblias:biblias]
		return  obj
	}

	def biblia = {
		def biblias = bibliaService.listAll()
		def livros = livroService.listByBiblia(params.biblia)
		if(!livros){
			response.sendError(HttpServletResponse.SC_NOT_FOUND)
		}
		def obj = [livros:livros,biblias:biblias]
		return obj
	}

	def livro = {
		def livros = livroService.listByBiblia(params.biblia)
		def capitulos = versiculoService.listNumeroCapitulosByLivro(params.biblia, params.livro)
		if(!capitulos){
			response.sendError(HttpServletResponse.SC_NOT_FOUND)
		}
		def obj = [livros:livros, capitulos:capitulos]
		return obj
	}

	def capitulo = {
		def livros = livroService.listByBiblia(params.biblia)
		def versiculos = versiculoService.listByCapitulo(params.biblia, params.livro, params.capitulo.toInteger())
		def obj = [livros:livros, versiculos:versiculos]
		if(!versiculos){
			response.sendError(HttpServletResponse.SC_NOT_FOUND)
		}
		return obj
	}

	def versiculo = {
		def livros = livroService.listByBiblia(params.biblia)
		def versiculo = versiculoService.getVersiculo(params.biblia, params.livro, params.capitulo.toInteger(), params.versiculo.toInteger())
		if(!versiculo){
			response.sendError(HttpServletResponse.SC_NOT_FOUND)
		}
		def obj = [livros:livros, versiculo:versiculo]
		return obj
	}
}
