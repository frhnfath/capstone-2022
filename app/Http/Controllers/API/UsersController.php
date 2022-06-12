<?php

namespace App\Http\Controllers\API;

use App\Helpers\ApiFormatter;
use App\Http\Controllers\Controller;
use App\Models\Akun;
use Illuminate\Http\Request;
use Exception;
use Illuminate\Support\Str;
use DB;
use Carbon\Carbon;

class UsersController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $data = Akun::all();

        if($data)
        {
            return ApiFormatter::createApi(200, 'Success', $data);
        }
        else 
        {
            return ApiFormatter::createApi(400, 'Fail');
        }
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        try{
            $request -> validate([
                'name' => 'required',
                'email' => 'required',
                'password' => 'required',
                'telepon' => 'required'
            ]);
            $time = Carbon::now()->toDateTimeString();
            $user = ['name' => $request -> name,
                'email' => $request -> email,
                'password' => $request -> password,
                'telepon' => $request -> telepon,
                'rule' => 'user',
                'hospital_id' => '0',
                'created_at' => $time,
                'updated_at' => $time
            ];
            DB::insert('insert into users (name, email, password, telepon, rule, hospital_id, created_at, updated_at) values (?, ?, ?, ?, ?, ?, ?, ?)', [$user['name'], $user['email'], $user['password'], $user['telepon'], 'user', 0, $user['created_at'], $user['updated_at']]);
            $data = Akun::where('email','=',$user['email'])->get();
            if($data)
            {
                return ApiFormatter::createApi(200, 'Success', $data);
            }
            else 
            {
                return ApiFormatter::createApi(400, 'Fail');
            }
        }
        catch (Exception $error)
        {
            return ApiFormatter::createApi(400, 'Fail');
        }
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($email)
    {
        $data = Akun::where('email','=',$email)->get()->toArray();
        $token = Str::random(32);
        $data[0]['remember_token'] =  $token;
        $time = Carbon::now()->toDateTimeString();
        DB::update('update users set remember_token = ?, updated_at = ? where email = ?', [$token, $time, $email]);
        if($data)
        {
            return ApiFormatter::createApi(200, 'Success', $data);
        }
        else 
        {
            return ApiFormatter::createApi(400, 'Fail');
        }
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        try{
            $request -> validate([
                'name' => 'required',
                'email' => 'required',
                'password' => 'required',
                'telepon' => 'required'
            ]);

            $time = Carbon::now()->toDateTimeString();
            $user = ['name' => $request -> name,
                'email' => $request -> email,
                'password' => $request -> password,
                'telepon' => $request -> telepon,
                'updated_at' => $time
            ];
            DB::update('update users set name = ?, email = ?, password = ?, telepon = ?, updated_at = ? where id = ?', [$user['name'],$user['email'],$user['password'],$user['telepon'],$user['updated_at'],$id]);
            $data = Akun::where('id','=',$id)->get();
            if($data)
            {
                return ApiFormatter::createApi(200, 'Success', $data);
            }
            else 
            {
                return ApiFormatter::createApi(400, 'Fail');
            }
        }
        catch (Exception $error)
        {
            return ApiFormatter::createApi(400, 'Fail');
        }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $user = Akun::findOrFail($id);
        $data = $user->delete();
        if($data)
        {
            return ApiFormatter::createApi(200, 'Delete Success');
        }
        else 
        {
            return ApiFormatter::createApi(400, 'Fail');
        }
    }
}