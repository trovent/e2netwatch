<?php

/*
    Copyright (C) 2017 e-ito Technology Services GmbH
    e-mail: info@e-ito.de

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

$json = '{
  "size": 0,
  "query": {
    "bool": {
      "must": [
        {
          "range": {
            "@timestamp": {
               "gte": "' . $startdate . '",
               "lte": "' . $enddate . '"
            }
          }
        },
        {
          "wildcard": {
            "TCPFlags": {
              "value": "*R*"
            }
          }
        }
      ]
    }
  },
  "aggs": {
    "ipaddress": {
      "terms": {
        "field": "DestinationAddress",
        "size": 10,
        "order": {
          "_count": "desc"
        }
      }
    }
  }
}';


$params = array(
    'index' => 'e2nw-netflow-*',
     'body' => $json
);

$response = $elastic->search($params);

$file = fopen("csv/340_Top_10_Destinations_with_Session_Resets.csv", "w");

    $txt = 'IP Address,Amount of Resets' . PHP_EOL;
    foreach ($response['aggregations']['ipaddress']['buckets'] as $data) {
         $txt .= $data['key'] . ',' . number_format($data['doc_count'],0,'','.') . PHP_EOL;
    }

fwrite($file, $txt);
fclose($file);

?>
