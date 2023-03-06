#!/bin/bash

wrk -t 1 -c 1 -R 100 -d 300 'http://localhost:8888/queryBooksByPage2?page=1&pageSize=10'
