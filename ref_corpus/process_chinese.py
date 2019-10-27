import os
import re
import jieba
import argparse

parser = argparse.ArgumentParser()
parser.add_argument('--data_path', required=True)
parser.add_argument('--output_path', required=True)
args = parser.parse_args()


with open(args.data_path) as file:
    texts = file.read().splitlines()

new_texts = []
with open(args.output_path, 'w') as file:
    for text in texts:
        tokens = jieba.cut(text)
        filtered_tokens = [re.sub(r'[^\u4e00-\u9fff]', '', token) for token in tokens]
        filtered_tokens = [token for token in filtered_tokens if token]
        file.write(" ".join(filtered_tokens) + '\n')
