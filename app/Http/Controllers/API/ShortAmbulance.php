<?php

namespace App\Http\Controllers\API;

use App\Helpers\ApiFormatter;
use App\Http\Controllers\Controller;
use App\Models\Ambulance;
use Illuminate\Http\Request;
use Exception;
use Illuminate\Support\Str;
use DB;
use Facade\FlareClient\Http\Response;

class ShortAmbulance extends Controller
{
    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
     public function short(Request $request)
     {
        try
        {
            $request -> validate([
                'lintang' => 'required',
                'bujur' => 'required'
            ]);
            
            $user = ['x1' => $request -> lintang,
                     'y1' => $request -> bujur];

            $resource = DB::select('select * from ambulance');
            $jarak = array();
            for($i=0; $i<10; $i++)
            {
                $temp = $resource[$i];
                $dLat = ($temp->lintang - $user['x1']) * M_PI / 180.0;
                $dLon = ($temp->bujur - $user['y1']) * M_PI / 180.0;
            
                // convert to radians
                $lat1 = ($temp->lintang) * M_PI / 180.0;
                $lat2 = ($user['x1']) * M_PI / 180.0;
            
                // apply formula
                $a = pow(sin($dLat / 2), 2) + pow(sin($dLon / 2), 2) * cos($lat1) * cos($lat2);
                $rad = 6371;
                $c = 2 * asin(sqrt($a));
                
                $hasil = $rad * $c;
                
                $jarak[$temp->id] = $hasil;
            }
            asort($jarak);
            foreach ($jarak as $key => $val)
            {
                $data = Ambulance::where('id','=',$key)->get()->toArray();
                if($data)
                {
                    return ApiFormatter::createApi(200, 'Success', $data);
                }
                else 
                {
                    return ApiFormatter::createApi(400, 'Fail');
                }
                break;
            }
        }
        catch (Exception $error)
        {
            return ApiFormatter::createApi(400, 'Fail');
        }
     }
}