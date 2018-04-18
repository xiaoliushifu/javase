<?php
require '../vendor/autoload.php';
use Elasticsearch\ClientBuilder;
$client = ClientBuilder::create()->build();

$params = [
    'index' => 'megacorp',
    'type' => 'employee',
	#body是指http的body体，get方法也可以有body体
    'body' => [
        'query' => [
		#match是一种查询表达式
            'match' => [
                'last_name' => 'Smith'
            ]
        ]
    ]
];
$response = $client->search($params);
echo "<pre>";
var_export($response);