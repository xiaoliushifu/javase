<?php
require '../vendor/autoload.php';
use Elasticsearch\ClientBuilder;
$client = ClientBuilder::create()->build();

$params = [
    'index' => 'megacorp',
    'type' => 'employee',
    'body' => [
        'query' => [
            'match_phrase' => [
                'about' => 'rock climbing'
            ]
        ],
		#增加高亮显示,但是一直报错格式不对，不知该JDK如何组织参数呢？
		'highlight'=> [
			'fields' => [
				'about' => [
					
				]
			]
		]
    ]
];
$response = $client->search($params);
echo "<pre>";
var_export($response);