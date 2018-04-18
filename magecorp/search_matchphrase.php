<?php
require '../vendor/autoload.php';
use Elasticsearch\ClientBuilder;
$client = ClientBuilder::create()->build();

$params = [
    'index' => 'megacorp',
    'type' => 'employee',
    'body' => [
        'query' => [
		#match_phrase比match更精准。只匹配"rock climbing"这个紧挨着的词组；而非分词后的单个词。
		#这种查询方式称之为：短语查询
            'match_phrase' => [
                'about' => 'rock climbing'
            ]
        ]
    ]
];
$response = $client->search($params);
echo "<pre>";
var_export($response);