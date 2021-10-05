<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
      .form-control{
        width: 400px;
        box-shadow: 0px 8px 9px 0px rgba(69, 69, 69, 0.25);
      }
      .container{
        padding-left: 300px;
        padding-top: 100px;
      }
      h2{
        padding-left: 130px;
        color: chocolate;
      }
      .btn{
        margin-left: 150px;
        background-color: green;
      }
      .form-group{
        color: chocolate;
      }
      .checkbox{
        color: chocolate;
      }
    </style>
</head>
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
<body>

<div class="container">
    <h2>Login Form</h2>
    <form method="post" id="loginForm">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
            <br>${message}
        </div>
        <div class="checkbox">
            <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
<script type="text/javascript">
  $(document).ready(function() {
    $("#loginForm").validate({
      rules: {
        email: {
          required: true
        },
        password: {
          required: true,
          minlength: 6
        }
      },
      messages: {
        email: {
          required: "The email is required!",
        },
        password: {
          required: "Please provide a password",
          minlength: "Your password must be at least 6 characters long"
        },
      }
    });
  });
</script>



</body>
</html>
