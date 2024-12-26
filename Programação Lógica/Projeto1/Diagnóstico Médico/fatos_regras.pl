% Fatos sobre sintomas e doenças
sintoma(gripe, febre).
sintoma(gripe, tosse).
sintoma(gripe, coriza).
sintoma(gripe, dor_de_cabeca).
sintoma(dengue, febre).
sintoma(dengue, dor_muscular).
sintoma(dengue, manchas_na_pele).
sintoma(dengue, dor_ao_movimento_dos_olhos).
sintoma(covid19, febre).
sintoma(covid19, tosse_seca).
sintoma(covid19, perda_de_olfato).
sintoma(covid19, dificuldade_respiratoria).
sintoma(meningite, febre).
sintoma(meningite, rigidez_na_nuca).
sintoma(meningite, dor_de_cabeca).
sintoma(meningite, fotofobia).
sintoma(pneumonia, febre).
sintoma(pneumonia, tosse_produtiva).
sintoma(pneumonia, falta_de_ar).
sintoma(pneumonia, dor_no_peito).
sintoma(gastrite, dor_abdominal).
sintoma(gastrite, queimacao).
sintoma(gastrite, nausea).
sintoma(gastrite, vomito).
sintoma(hepatite, ictericia).
sintoma(hepatite, febre).
sintoma(hepatite, dor_no_abdome_direito).
sintoma(hepatite, urina_escura).
sintoma(sinusite, dor_facial).
sintoma(sinusite, congestao_nasal).
sintoma(sinusite, dor_de_cabeca).
sintoma(sinusite, febre).

% Gravidade dos sintomas
gravidade(febre, moderado).
gravidade(tosse, leve).
gravidade(coriza, leve).
gravidade(dor_de_cabeca, moderado).
gravidade(dor_muscular, severo).
gravidade(manchas_na_pele, severo).
gravidade(dor_ao_movimento_dos_olhos, severo).
gravidade(tosse_seca, moderado).
gravidade(perda_de_olfato, moderado).
gravidade(dificuldade_respiratoria, severo).
gravidade(rigidez_na_nuca, severo).
gravidade(fotofobia, moderado).
gravidade(tosse_produtiva, moderado).
gravidade(falta_de_ar, severo).
gravidade(dor_no_peito, severo).
gravidade(dor_abdominal, moderado).
gravidade(queimacao, leve).
gravidade(nausea, leve).
gravidade(vomito, moderado).
gravidade(ictericia, severo).
gravidade(dor_no_abdome_direito, severo).
gravidade(urina_escura, severo).
gravidade(dor_facial, moderado).
gravidade(congestao_nasal, leve).

% Regra para diagnóstico
diagnostico(Doenca, Sintomas, Probabilidade) :-