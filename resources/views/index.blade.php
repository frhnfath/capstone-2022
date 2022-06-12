<!DOCTYPE html>
<html>
<head>
	<title>Hospital Monitoring Website</title>
	<link href="img/undraw_best_place_re_lne9.svg" rel="icon">
	<link rel="stylesheet" type="text/css" href="css/index.css">
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
			<form action="/login" method="POST">
				@csrf
				<img src="img/undraw_male_avatar_323b.svg">
				<h2 class="title">Welcome</h2>
				@if(session()->has('loginError'))
					<h3 class="title">{{ session('loginError') }}</h3>
				@endif
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Email</h5>
           		   		<input type="text" name="email" id="email" class="input @error('email') is-invalid @enderror" required>
					</div>
           		</div>
				@error('email')
					<div class="invalid-feedback">
						{{ $message }}
					</div>
				@enderror
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Password</h5>
           		    	<input type="password" name="password" id="password" class="input" required>
            	   </div>
            	</div>
				<input type="hidden" name="rule" id="rule" value="admin_rs" required>
            	<input type="submit" class="btn" name="submit" id="submit" value="Login">
            </form>
        </div>
    </div>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>
