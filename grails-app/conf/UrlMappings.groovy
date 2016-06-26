class UrlMappings {

	static mappings = {
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"{
			controller = "bibliaOnline"
			action = "index"
		}
		
		"500"(view:'/error')
		
		"/$biblia"{
			controller = "bibliaOnline"
			action = "biblia"
			constraints {
				biblia(matches: /.*^\w{3}$.*/)
				
			}
		}
		
		"/$biblia/$livro"{
			controller = "bibliaOnline"
			action = "livro"
			constraints {
				biblia(matches: /.*^\w{3}$.*/)
				livro(matches: /.*^\w{2}$.*/)
				
			}
		}
		
		"/$biblia/$livro/$capitulo"{
			controller = "bibliaOnline"
			action = "capitulo"
			constraints {
				biblia(matches: /.*^\w{3}$.*/)
				livro(matches: /.*^\w{2}$.*/)
				
			}
		}
		
		"/$biblia/$livro/$capitulo/$versiculo"{
			controller = "bibliaOnline"
			action = "versiculo"
			constraints {
				biblia(matches: /.*^\w{3}$.*/)
				livro(matches: /.*^\w{2}$.*/)
				
			}
		}		
	}
}
