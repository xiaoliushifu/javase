<?php
require 'vendor/autoload.php';
use Elasticsearch\ClientBuilder;
$client = ClientBuilder::create()->build();

$params = [
    'index' => 'my_index',
    'type' => 'my_type',
    'body' => [
        'query' => [
            'match' => [
                'testField' => 'abc'
            ]
        ]
    ]
];
//搜索，使用match方式搜索testField字段匹配'abc'的文档,match是全等吗？
$response = $client->search($params);
echo "<pre>";
var_export($response);