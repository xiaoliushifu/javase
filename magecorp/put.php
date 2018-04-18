<?php
require '../vendor/autoload.php';

use Elasticsearch\ClientBuilder;

$client = ClientBuilder::create()->build();

#创建一个索引文档，按照sdk的说法，这些都是关联数组
$params = [
    'index' => 'megacorp',
    'type' => 'employee',
    'id' => '1',
    'body' => ['first_name' => 'John','last_name'=>'Smith',
			'age'=>25,'about'=>'I love to go rock climbing',
			'interests'=>[ "music","sports"]
			]
];
$params = [
    'index' => 'megacorp',
    'type' => 'employee',
    'id' => '2',
    'body' => ['first_name' => 'Jane','last_name'=>'Smith','age'=>32,'about'=>'I like to collect rock albums','interests'=>[ "music" ]]
];
$params = [
    'index' => 'megacorp',
    'type' => 'employee',
    'id' => '3',
    'body' => ['first_name' => 'Douglas','last_name'=>'Fir',
	'age'=>32,'about'=>'I like to build cabinets',
	'interests'=>[ "forestry"]
	]
];
$response = $client->index($params);
echo "<pre>";
var_export($response);