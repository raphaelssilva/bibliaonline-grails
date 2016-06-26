package biz.r2s.bibliaonline

import grails.converters.JSON;

class BibliaController {
    def bibliaService

    def get(String  id){
        render bibliaService.getBiblia(id) as JSON
    }

    def all(){
        render bibliaService.listAll() as JSON
    }
}
