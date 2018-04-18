<?php
require '../vendor/autoload.php';
use Elasticsearch\ClientBuilder;
$client = ClientBuilder::create()->build();

$params = [
    'index' => 'megacorp',
    'type' => 'employee',
    'body' => [
		//类似于sql的group by效果
        'aggs' => [
            'all_interests' => [
                'terms' => [
					'field'=>'interests'
				]
            ]
        ]
    ]
];
$response = $client->search($params);
echo "<pre>";
var_export($response);