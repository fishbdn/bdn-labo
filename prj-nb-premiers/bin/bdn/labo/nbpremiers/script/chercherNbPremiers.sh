#!/bin/bash 

## Parametre d'entree : nombre de demarrage de la recherche
start=$(date "+%Y-%m-%d %H:%M:%S");

nb=$1;
while [[ 1==1 ]]
do
	# Iteration de recherchde de demarrage
	i=2;
	# On itere pour chercher un reste de division non nule
	while [ $(($nb % i)) -ne 0 ] 
	do 
		i=$((i+1)) 
		#echo $i;
	done 

	if [ $i -eq $nb ]; then 
		echo " $nb est premier ! [$(date "+%Y-%m-%d %H:%M:%S")]" 
	fi

	nb=$(($nb+1)); 
done

while [ $nb -lt $max ]
do
	echo $nb;
	nb=$(($nb+1)); 
done


