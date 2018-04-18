<?php
require 'vendor/autoload.php';

use Elasticsearch\ClientBuilder;

$client = ClientBuilder::create()->build();

#删除整个索引
$deleteParams = [
    'index' => 'my_index'
];
#该方式
$response = $client->indices()->delete($deleteParams);
print_r($response);
echo "<pre>";
var_export($response);