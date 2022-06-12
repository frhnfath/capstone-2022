<?php

namespace App\Http\Controllers;

use App\Models\Hospital;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Models\User;

class LoginController extends Controller
{
    public function index(Request $request)
    {
        return view('index');
    }

    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function authenticate(Request $request)
    {
        $credentials = $request->validate([
            'email' => 'required|email:dns',
            'password' => 'required',
            'rule' => 'required'
        ]);

        $user = ['email' => $request -> email,
                'password' => $request -> password,
                'rule' => $request -> rule
        ];

        $data = User::where('email','=',$user['email'])->get()->toArray();
        $data_rs = Hospital::where('kode','=', $data[0]['hospital_id'])->get()->toArray();
        if($data[0]['email'] == $user['email'] && $data[0]['password'] == $user['password'] && $data[0]['rule'] == 'admin_rs')
        {
            $request->session()->put('kode', $data[0]['hospital_id']);
            $request->session()->put('nama', $data_rs[0]['nama']);
            return redirect()->intended('/main');
        }
        else
        {
            return back()->with('loginError', 'Login Failed!');
        }
    }
}