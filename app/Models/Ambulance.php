<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Ambulance extends Model
{
    use HasFactory;

    public $table = 'ambulance';
    public $fillable = [
        'id', 
        'nama_ambulan', 
        'nama_driver', 
        'lintang', 
        'bujur', 
        'alamat', 
        'telepon'
    ];
}
