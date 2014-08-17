#!/bin/bash 

i=2 

while [ $(($1%i)) -ne 0 ] 
do 
	i=$((i+1)) 
	echo $i 
done 

if [ $i -ne $1 ]; then 
	echo " $1 n'est pas premier ! voici deux diviseurs :" 
	echo $i 
	echo $(($1/i)) 
else 
	echo " $1 est premier !" 
fi 
