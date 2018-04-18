<?php
require '../vendor/autoload.php';
use Elasticsearch\ClientBuilder;
$client = ClientBuilder::create()->build();

$params = [
    'index' => 'megacorp',
    'type' => 'employee',
    'body' => [
        'query' => [
		#match是一种查询表达式,自动使用全文搜索。分词为rock,climbing,rock climbing三个词来查。
		#并按照相关性排序
            'match' => [
                'about' => 'rock climbing'
            ]
        ]
    ]
];
$response = $client->search($params);
echo "<pre>";
var_export($response);