Run Postgres with:
`docker run --name microservices-postgres -e POSTGRES_PASSWORD=microservices -e POSTGRES_DB=microservices -p 5432:5432 -d postgres`

Then create the following 3 schemas:`account`, `inventroy` and `sale`