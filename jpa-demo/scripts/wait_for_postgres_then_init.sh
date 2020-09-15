#!/usr/bin/env bash
/scripts/wait-for-it.sh postgres:5432 -- /scripts/liquibase-init.sh