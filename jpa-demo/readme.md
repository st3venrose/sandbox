## JPA demo app

### Local development

Maven use `dev` profile as default.

Run liquibase with maven resources:
```
mvn resources:resources liquibase:update
```


You can run a postgresql docker image with following command:
```
docker run --name jpa-demo -e POSTGRES_PASSWORD=jpa-demo -e POSTGRES_DB=jpa-demo -d -p 5432:5432 postgres
```
## How to run it

### Run with docker compose

```
docker-compose up -d
```

If you want to stop it:

```
docker-compose down
```

### More commands

Create app docker image:
```
docker build -t jpa-demo-app .
```

Then you can run it:
```
docker run jpa-demo-app
```





