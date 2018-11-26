#!/bin/bash

# Create a named volume

# from image gutenberg/books-mongodb to volume books-mongodb

sudo docker volume rm gutenberg-books-db

sudo docker run --name books_create -d --rm --mount source=gutenberg-books-db,target=/data/db \
--env MONGO_INITDB_ROOT_USERNAME=root --env MONGO_INITDB_ROOT_PASSWORD=root gutenberg/books-mongodb


