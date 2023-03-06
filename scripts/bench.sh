#!/bin/bash

wrk -c 8 -R 100 -d 300 'http://localhost:8888/countAllBookPages'
