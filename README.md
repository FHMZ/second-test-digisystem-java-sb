# API DIGISYSTEM - second-test-digisystem

Como acessar os metodos criados (Postman)

1 - Listar todos os registros, no postman coloque GET: localhost:8080//digisystem/pessoa

2 - Listar registros por id, no postman coloque GET: localhost:8080/digisystem/pessoa/{id}

3 - Listar registros por nome, no postman coloque GET: localhost:8080/digisystem/pessoa/name/{nome}

4 - Listar registros por salario, no postman coloque GET: localhost:8080/digisystem/pessoa/salary/{salary}

5 - Salvar registro, no postman coloque POST: localhost:8080/digisystem/pessoa
Utilize o body no seguinte formato:
{
   "id": 1,
   "nome": "Nome Sobrenome",
   "idade": "30",
   "salario": "1.000,00"
}
