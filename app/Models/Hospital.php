<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Hospital extends Model
{
    use HasFactory;
    
    public $table = 'hospital';
    public $fillable = [
        'kode', 
        'nama', 
        'jenis', 
        'tipe', 
        'lintang', 
        'bujur', 
        'alamat', 
        'bed_avail', 
        'telepon'
    ];
    
    /**
     * The attributes that should be hidden for arrays.
     *
     * @var array
     */
    public $hidden = [];
}
