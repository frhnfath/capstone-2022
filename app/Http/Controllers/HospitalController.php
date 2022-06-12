<?php

namespace App\Http\Controllers;

use App\Models\Hospital;
use Illuminate\Http\Request;
use Exception;
use DB;

class HospitalController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index(Request $request)
    {
        $data_rs = Hospital::where('kode','=', $request->session()->get('kode'))->get()->toArray();
        return view('main', ['nama' => $request->session()->get('nama'),
                             'bed_avail' => $data_rs[0]['bed_avail']]);
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
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
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
    public function update(Request $request)
    {
        try{
            $request -> validate([
                'bed' => 'required'
            ]);

            $hospital = ['bed' => $request -> bed];
            $id = $request->session()->get('kode');
            DB::update('update hospital set bed_avail = ? where kode = ?', [$hospital['bed'], $id]);
            
            $data = Hospital::where('kode','=',$id)->get();
            if($data)
            {
                return redirect()->intended('/main');
            }
            else 
            {
                return back()->with('updateError', 'Update Failed!');
            }
        }
        catch (Exception $error)
        {
            return back()->with('updateError', 'Update Failed!');
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
        //
    }
}
