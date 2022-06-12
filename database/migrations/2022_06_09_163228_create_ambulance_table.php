<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateAmbulanceTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('ambulance', function (Blueprint $table) {
            $table->id();
            $table->string('nama_ambulan');
            $table->string('nama_driver');
            $table->double('lintang');
            $table->double('bujur');
            $table->string('alamat');
            $table->bigInteger('telepon');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('ambulance');
    }
}
