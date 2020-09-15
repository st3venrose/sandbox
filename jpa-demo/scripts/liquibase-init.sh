#!/usr/bin/env bash

/opt/liquibase/liquibase \
    --driver=org.postgresql.Driver \
    --url=jdbc:postgresql://db:5432/$POSTGRES_DB \
    --liquibaseSchemaName=public \
    --classpath=/usr/share/java/postgresql.jar \
    --changeLogFile=/changelog/db-changelog.xml \
    --username=$POSTGRES_USER \
    --password=$POSTGRES_PASSWORD \
    --contexts=all \
    update