<?php

use App\Http\Controllers\API\ShortAmbulance;
use App\Http\Controllers\API\ShortHospital;
use App\Http\Controllers\API\UsersController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/
Route::get('users', [UsersController::class, 'index']);
Route::get('users/show/{email}', [UsersController::class, 'show']);
Route::post('users/update/{id}', [UsersController::class, 'update']);
Route::post('users/store', [UsersController::class, 'store']);
Route::post('users/destroy/{id}', [UsersController::class, 'destroy']);
Route::post('short/hospital', [ShortHospital::class, 'short']);
Route::post('short/ambulance', [ShortAmbulance::class, 'short']);
Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});