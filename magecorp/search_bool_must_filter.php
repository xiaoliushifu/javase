<?php
require '../vendor/autoload.php';
use Elasticsearch\ClientBuilder;
$client = ClientBuilder::create()->build();

$params = [
    'index' => 'megacorp',
    'type' => 'employee',
    'body' => [
	#另一种搜索：搜索姓氏为 Smith 的雇员，过滤出年龄大于 30 的
        'query'=>[
			'bool' => [
		#match是一种查询表达式
				'must' => [
					'match'=>[
						'last_name' => 'Smith'
					]
				],
				'filter'=>[
					"range"=>[
						"age"=>[
							'gt' => 30
						]
					]
				]
			]
		]
    ]
];
$response = $client->search($params);
echo "<pre>";
var_export($response);