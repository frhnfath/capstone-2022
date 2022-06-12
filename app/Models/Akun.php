<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class Akun extends Model
{
    use HasFactory;
    use SoftDeletes;

    public $table = 'users';
    public $fillable = [
        'name',
        'email',
        'password',
        'telepon',
        'rule',
        'hospital_id'
    ];

    public $hidden = [];
}
