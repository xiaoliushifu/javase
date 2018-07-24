<?php
require 'vendor/autoload.php';

use Monolog\Logger;
use Monolog\Handler\StreamHandler;
use Elasticsearch\ClientBuilder;

#准备日志组件
$logger = new Logger('name');
$logger->pushHandler(new StreamHandler('path/to/your.log', Logger::WARNING));

$client = ClientBuilder::create()->setLogger($logger)->build();

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