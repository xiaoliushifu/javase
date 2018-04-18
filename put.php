<?php
require 'vendor/autoload.php';

use Elasticsearch\ClientBuilder;

$client = ClientBuilder::create()->build();

#创建一个索引文档，按照sdk的说法，这些都是关联数组
$params = [
    'index' => 'my_index',
    'type' => 'my_type',
    'id' => '1',
    'body' => ['name' => '老刘','desc'=>'工程师']
];
$response = $client->index($params);
echo "<pre>";
var_export($response);