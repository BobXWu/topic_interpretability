python process_wiki.py raw_wiki/zhwiki-latest-pages-articles.xml.bz2 ./tmp_2

opencc -i tmp_1 -o tmp_s -c /usr/share/opencc/t2s.json

python process_chinese.py --data_path tmp_s --output_path test_1

