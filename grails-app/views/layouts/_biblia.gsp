<div class="biblia">
	<g:each in="${livros?.groupBy{it.testamento}?.sort {it.key.id}}" var="testamento">
		<div class="testamento">
			<p>
				${testamento.key.nome}
			</p>
			<g:each in="${testamento.value}" var="livro">
				<div class="livro">
					<g:link absolute="true" base="" url="/${params.biblia?:"nad"}/${livro.sigla}">
						<span>
							${livro.nome}
						</span>
					</g:link>
				</div>
			</g:each>
		</div>
	</g:each>
</div>