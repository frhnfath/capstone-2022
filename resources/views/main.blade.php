<!DOCTYPE html>
<html>
<head>
	<title>Hospital Monitoring Website</title>
	<link href="img/undraw_best_place_re_lne9.svg" rel="icon">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
		<div class="img">
			<img src="img/undraw_medicine_b-1-ol (1).svg">
		</div>
		<div class="login-content">
			<form action="/main" method="POST">
				@csrf
				<img src="img/undraw_male_avatar_323b.svg">
				<h2 class="title_rs"><?php echo $nama; ?></h2>
				@if(session()->has('updateError'))
					<h3 class="title">{{ session('updateError') }}</h3>
				@endif
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fa fa-bed"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Current Capacity : <?php echo $bed_avail; ?> Bed</h5>
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class='fa fa-plus-circle'></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Update Capacity</h5>
           		    	<input type="number" name="bed" id="bed" class="input" min="0" required>
            	   </div>
            	</div>
            	<input type="submit" class="btn" name="update" id="update" value="Update Capacity">
            </form>
        </div>
    </div>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>
