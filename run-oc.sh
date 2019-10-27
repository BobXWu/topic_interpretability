#!/bin/bash

#script that computes the observed coherence (pointwise mutual information, normalised pmi or log 
#conditional probability)
#steps:
#1. sample the word counts of the topic words based on the reference corpus
#2. compute the observed coherence using the chosen metric

set -e

#parameters
metric="npmi" #evaluation metric: pmi, npmi or lcp
#input
topic_file=${1}
ref_corpus_dir=${2}

# ref_corpus_dir="ref_corpus/wikipedia"
# ref_corpus_dir="../MultiLingual/data/wiki_shorts2/train_texts_cn"

#output
# wordcount_file="wordcount/wc-oc.txt"
# oc_file="results/topics-oc.txt"

window_size=20
# window_size=50

wordcount_file=`dirname ${topic_file}`/wc_`basename ${topic_file}`

touch ${wordcount_file}

#compute the word occurrences
echo "Computing word occurrence..."
python src/ComputeWordCount.py ${topic_file} ${ref_corpus_dir} ${wordcount_file} ${window_size} #> ${wordcount_file}

# compute the topic observed coherence
echo "Computing the observed coherence..."
python src/ComputeObservedCoherence.py ${topic_file} ${metric} ${wordcount_file}
# > $oc_file

# rm ${wordcount_file}
