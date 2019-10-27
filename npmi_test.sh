#!/bin/zsh
set -e


model=${1}
dataset=${2}
K=${3}
lang=${4}
ref_corpus=${5}
start=${6}
end=${7}

for T in 15
do
    echo "-----" T=${T} "------"
    for j in {${start}..${end}}
    do
        ./run-oc.sh ../MultiLingual/${model}/output/${2}/top_words_T${T}_K${K}_${lang}_${j}th ${ref_corpus} | tail -1
    done
done > ./output/${model}_${dataset}_K${K}_${lang}_`basename ${ref_corpus}`
