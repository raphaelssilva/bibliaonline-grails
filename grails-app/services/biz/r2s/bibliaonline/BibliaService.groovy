package biz.r2s.bibliaonline

class BibliaService {
	def getBiblia(String  biblia){
		Biblia.findBySigla(biblia)
	}
	
	def listAll(){
		Biblia.all
	}
}
