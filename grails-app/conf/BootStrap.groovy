import biz.r2s.bibliaonline.Biblia
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Biblia, {Biblia b ->
            return [
                id:b.id,
                nome:b.nome,
                sigla:b.sigla,
                edicao:b.edicao,
                linguagem:b.linguagem
            ]
        })

    }
    def destroy = {
    }
}
