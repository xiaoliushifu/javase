<?php
require 'vendor/autoload.php';

use Elasticsearch\ClientBuilder;

$client = ClientBuilder::create()->build();

$params = [
    'index' => 'my_index',
    'type' => 'my_type',
    'id' => '1',
];
//根据，索引，类型，文档编号删除指定文档
$response = $client->delete($params);
echo "<pre>";
var_export($response);