#!/bin/sh

echo "Compilando Backend - SpringBoot"

cd todo-list-back/
#compila el back
mvn clean install

cd ..

echo "Compilando Fronted - Angular"

cd todo-list-front/
#instala devDependencias del front
npm install
#instala servidor
npm i -g serve
#compila el front
ng build

cd ..
echo "Iniciando Backend & Fronted"
#inicia el back y luego el front
 cd todo-list-front/  &&  nohup serve -p 4300 -S dist/todo-list-front -d &&
 cd .. & cd todo-list-back/  &&  nohup java -jar target/todo-list-0.0.1-SNAPSHOT.jar &
