# OLDFLIX

API para locadora de filmes

## 🚀 Tecnologias Utilizadas

- Java
- Spring
- Javascript
- React
- Postgres

## Recursos

- Incluir filmes: `POST /filmes`
- Atualizar filme: `PUT /filmes/{id}`
- Alugar filme: `PUT /filmes/{id}/alugar`
- Devolver filme: `PUT /filmes/{id}/devolver`
- Listar filmes: `GET /filmes`
- Detalhes filme: `GET /filmes/{id}`
- Deletar filme: `DELETE /filmes/{id}`

### Inicializando a API

```bash
# Banco de dados Postgres
    - Criar um banco de dados com o nome oldflix
    - Executar a API em um editor de código 
    - Ao executar a API as migrations do Flyway criarão as tabelas e farão os inserts iniciais
```

### A api conta com:
- Controlador global para exceptions do tipo ResponseStatusException
- Serializador de Datas para fácil manipulação de novos formatos
- Configuração de CORS para dominio especifico
- Versionamento do banco de dados com Flyway


![oldflix](https://github.com/Ismael-r-pithan/TCC-Rental-Stores/assets/77652899/1fe8e28e-c5b5-4b63-b009-d74455f2bb31)


