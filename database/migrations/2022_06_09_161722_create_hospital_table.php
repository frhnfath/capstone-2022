<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateHospitalTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('hospital', function (Blueprint $table) {
            $table->integer('kode')->primary();
            $table->string('nama');
            $table->string('jenis');
            $table->string('tipe');
            $table->double('lintang');
            $table->double('bujur');
            $table->string('alamat');
            $table->integer('bed_avail');
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
        Schema::dropIfExists('hospital');
    }
}
